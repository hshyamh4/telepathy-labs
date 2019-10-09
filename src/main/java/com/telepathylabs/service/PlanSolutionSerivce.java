package com.telepathylabs.service;

import static java.util.stream.Collectors.toCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.telepathylabs.domain.Feature;
import com.telepathylabs.domain.Plan;

@Service
public class PlanSolutionSerivce {

	public Plan[] getPlansByFeatures(Plan[] allPlans, Feature[] selectedFeatures) {

		Set<Feature> selectedFeaturesSet = new HashSet<>(selectedFeatures.length);
		for (Feature feature : selectedFeatures) {
			selectedFeaturesSet.add(feature);
		}

		Map<Feature, List<Plan>> pairs = new HashMap<>(selectedFeatures.length);

		for (Plan plan : allPlans) {
			for (Feature feature : plan.getFeatures()) {
				if (!selectedFeaturesSet.contains(feature)) {
					continue;
				}
				List<Plan> list = pairs.get(feature);
				if (list == null) {
					list = new ArrayList<>();
					pairs.put(feature, list);
				}
				list.add(plan);

			}
		}

		List<Plan> directMatchedPlans = pairs.values().stream().flatMap(List::stream)
				.collect(toCollection(ArrayList::new));

		Optional<Plan> findFirstIfAny = directMatchedPlans.stream()
				.filter(plan -> Collections.frequency(directMatchedPlans, plan) == selectedFeaturesSet.size()).sorted()
				.findFirst();

		Plan[] finalPlans = findFirstIfAny.isPresent() ? new Plan[] { findFirstIfAny.get() }
				: pairs.entrySet().stream().map(entry -> new TreeSet<>(entry.getValue()).first())
						.collect(toCollection(TreeSet::new)).toArray(new Plan[0]);

		if (finalPlans.length > 0) {
			return finalPlans;
		}

		return new Plan[0];
	}

}
