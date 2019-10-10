
- checkout the project from ```https://github.com/hshyamh4/telepathy-labs.git```
- goto folder location ```telepathy-labs```
- execute ```mvn clean install```
  - start the application by executing ``` java -jar target/telepathy-labs.jar``` in the command prompt
    (or)
  - import the project into eclipse, and start the application by running ```com.telepathylabs.Application```
- project is integrated with swagger, so we can access application at http://localhost:8080/swagger-ui.html 
- sample input files available in ```/src/test/resources```

Solution 1: 

> we can expect best plans along with their costs like below,
```
[
  {
    "name": "PLAN1",
    "features": [
      {
        "name": "voice"
      },
      {
        "name": "email"
      }
    ],
    "cost": 100
  },
  {
    "name": "PLAN3",
    "features": [
      {
        "name": "voice"
      },
      {
        "name": "admin"
      }
    ],
    "cost": 125
  }
]
```

Solution 2: 
> we can expect resultant tree like below
```
{
  "id": "A",
  "children": [
    {
      "id": "B",
      "children": null,
      "right": {
        "id": "C",
        "children": null,
        "right": {
          "id": "D",
          "children": null,
          "right": null
        }
      }
    }
  ],
  "right": null
}
```
