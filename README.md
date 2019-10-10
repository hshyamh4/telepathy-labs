> source code
- checkout the project from ```https://github.com/hshyamh4/telepathy-labs.git```
- goto folder location ```telepathy-labs```
> run through command prompt
- execute ```mvn clean install``` and start the application by executing ``` java -jar target/telepathy-labs.jar``` in the command prompt.
> run through IDE 
- import the project into eclipse, and start the application by running ```com.telepathylabs.Application```
> end points description
- project is integrated with swagger, so we can access the application at http://localhost:8080/swagger-ui.html 
> input files
- sample input files available at ```/src/test/resources```

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
