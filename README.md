
- Checkout the projectfrom ```https://github.com/hshyamh4/telepathy-labs.git```
- gotp folder location ```telepathy-labs``` folder
- Execute ```mvn clean install```
  - Execute ``` java -jar target/telepathy-labs.jar``` 
    (or)
  - Import the project into eclipse and start the application by running ```com.telepathylabs.Application```
- Project is integrated with swagger, so can access application at http://localhost:8080/swagger-ui.html 
- Sample input files available in ```/src/test/resources```

Solution 1: 

> You can expect best plans along with their costs like below,
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
> You can expect resultant tree like below
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
