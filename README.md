# Memory-Master
 
 This project is a memory mobile game played on Harry Potter movie characters and aims to find two matching pictures. This game can be played either for single player or for two players.
 
 The screens in the project are the login screen, the player selection screen, the game difficulty level selection screen and the game screen.
 
 The login screen is the page that opens on the screen when the game is first opened. On this screen, the user can log in with his username and password, change the password and register. Login information is kept in the database as user name, password, id information and e-mail account. I used Firebase for database.
 
 The player selection screen is the screen that will appear after the user logs in. There are two different options here as single player and multiplayer. The game difficulty level selection screen is 3 different difficulty level selection screens as 2*2, 4*4 and 6*6.
 
 The game screen is the screen where the game will take place. When the game starts, the cards are dealt face down. There is a pair of each of the cards in the game. The player clicks on a card and the card is revealed. Then the player tries to find the match of the card by clicking on a different card. The aim here is to find the other pair of the opened card within a certain time. In the game, cards are first dealt randomly.
 
 The game has music. These musics are always background music; sound effects that will play when the card is matched, when the game time is over, and if all the cards are matched before the game time ends.
 
 In Single Player, the game works as mentioned above. Game time is 45 seconds. In Multiplayer, cards are randomly dealt face down at the start of the game. The first player starts the game and chooses a card. He then tries to find the match of the card. If the card finds its match, the same player continues the game. If the card cannot find its match, the turn passes to the opposing player. Game time is 60 seconds.
 
 There is a scoring system. Each card in the game has a point and a house. If the player makes a correct match, a point is calculated using the house where the card is located, the card's score and the remaining time and displayed on the screen instantly. In case of a wrong match, if two cards are from the same house, the score calculated using the three card features above is subtracted and displayed on the screen instantly. In case of a wrong match, if the two cards are from different houses, the score calculated using the house scores of the two cards and the remaining time is subtracted and displayed on the screen instantly.

![1](https://github.com/umuutguler/Memory-Master/assets/74297248/951e0f7e-88be-4247-8c8a-5dd17a1797e6)
![2](https://github.com/umuutguler/Memory-Master/assets/74297248/6b5628d2-9c5b-4efe-ab6a-16e9998ed847)
![3](https://github.com/umuutguler/Memory-Master/assets/74297248/d2556300-851c-4e6b-a46f-3a509823414d)
