# CRUD API

The REST API performs CRUD operations on Animal objects as described below.

## API Endpoints
Use POSTMAN to try the following endpoints:

## Get list of Animals

### Request

    `GET /animals/all`

### Response

     [
   
     {"animalId": 1, "name": "cat", "species": "feline", "scientificName": "", "habitat": "house"}, 
   
     {"animalId": 2, "name": "dog", "species": "canine", "scientificName": "", "habitat": "house}, 
   
     ]

## Get a specific Animal

### Request

`GET /animals/{animalId}`


### Response

    {
     "animalId": 1, "name": "cat", "species": "feline", "scientificName": "", "habitat": "house"
    }

     
## Create a new Animal

### Request

    `POST /animals/new`
  

   ### Response

   [
   
     {"animalId": 1, "name": "cat", "species": "feline", "scientificName": "", "habitat": "house"}, 
   
     {"animalId": 2, "name": "dog", "species": "canine", "scientificName": "", "habitat": "house"}, 

     {"animalId": 3, "name": "mouse", "species": "rodent", "scientificName": "", "habitat": "house"}
   
  ]

## Get animals by species

### Request

    `GET /animals/species?species=canine`

### Response

     [
   
     {"animalId": 2, "name": "dog", "species": "canine", "scientificName": "", "habitat": "house"}
   
     ]


## Update an existing Animal 

### Request

    `PUT /animals/update/{animalId}`
    

   ### Response
   
    {
      "animalId": 1, "name": "sampleUpdated", "species": "updated", "scientificName": "Felius catus", "habitat": "house"
    }


## Delete an existing Animal

### Request

    `DELETE /animals/delete/{animalId}`
    

   ### Response
   
   [
   
     {"animalId": 1, "name": "cat", "species": "feline", "scientificName": "", "habitat": "house"}, 

     {"animalId": 3, "name": "mouse", "species": "rodent", "scientificName": "", "habitat": "house"}
   
  ]
