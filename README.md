
1. Run mvn clean install
2. Start the application by running com.telepathylabs.Application
3. Project is integrated with Swagger, so can use http://localhost:8080/swagger-ui.html 
4. Sample input files available in /src/test/resources

Solution 1: 

You can expect best plans along with their costs like below,

[code]

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
[/code]
Solution 2: You can expect resultant tree like below

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
