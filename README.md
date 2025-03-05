### Implement CardService which API should provide methods:

1. User’s registration
2. User’s login
3. Get card’s list

   Security must be implemented with Token Authentication (JWT, Opaque).

### Response Body of Get card’s list method is an array of objects with fields:
 Id - number, not null

 Obfuscated Card Number - string, not null, format: XXXX XX** **** XXXX, where X - is a digit

 Card’s currency - string, not null, 3 letters code (AMD, EUR, USD)

 Balance - decimal number, nullable

 Digit Wallet Account Id - string, nullable, format: UUID



###   Information stored in local DB: card id, card number (full), currency.


## There are two external services (no implementations needed, use mocks): SmartMoney and DigitalWallet.


### SmartMoney provides a method: GET /api/v1/{card_id}/balance.  
   Response body contains:

   balance - decimal, not null

   Example: 
   ```
   { 
   “balance”: 23456.23 
   }
   ```
   Also can return 404 and 500 without body.
### DigitalWallet provides a method: POST /api/v1/references.  

   Request body:
   
```cardIds - array of numbers, not null```
   

Example: 
```
   { 
   “cardIds“: [234353, 193847, 987324] 
   }
```

   Response body:
```
 cardRefs - array of objects, not null
 cardRefs.cardId - number, not null
 cardRefs.ref - string, nullable, format: uuid
```   
Example:

```
   {  
      “cardRefs”: [  
         {"cardId": 234353, "ref": "e1d13050-81a3-42d5-9aba-7ec786cf82b4"},
         {"cardId": 234353, "ref": "c82b1e76-39fc-4622-8530-b1b88f108884"},
         {"cardId": 987324, "ref": null}
      ]
   }
```     

If the field ref is null it means that the card with id cardId is not registered yet. The field ref is
always the same for the same card with id cardId.
Test coverage is optional, but preferred. 