# Veggie Ninja

We hope you enjoy this new version of the universally known game of Fruit Ninja! 

![2022-01-07 13-04-44](https://user-images.githubusercontent.com/78383220/148607701-ed14e81f-3fa3-42ee-ba6e-d03f8641d33a.gif)

## Description

In this game, the goal is to slice as many veggies as you can in the span of 60 seconds! Some veggies move faster than others, and the locations are all randomized, making the game a little unpredictable. You will use a knife to slice the different vegetables, which include: corn, carrots, potatos, lettuce, broccoli, and onion. As the game progress, more and more veggies fall onto the screen, and players can slice more than one vegetable at a time. 

## How to Play

- Press E to start
- Move cursor to move knife
- Press space to restart

## Classes

### Broccoli Class:

This class for the broccoli object, the fastest out of the six veggies! There is an array of 30 broccoli objects created in the frame. When hit, the object changes into a cut-up version of itself. 

![broccoli](https://user-images.githubusercontent.com/78383220/148604029-14990d1d-f31c-4472-ac47-68aaa9d7d5e6.PNG)

### Corn Class:

This class is for the corn object, another veggie you are trying to slice! There is an array of 30 corn objects created in the frame. When hit, the object changes into a cut-up version of itself. 

![corn](https://user-images.githubusercontent.com/78383220/148603990-970cc5d4-6cdc-41d3-9c71-6b46d99edbe7.PNG)

### Carrot Class:

This class is for the carrot object, another veggie you are trying to slice for 1 point! There is an array of 30 carrot objects created in the frame. When hit, the object changes into a cut-up version of itself. 

![carrot](https://user-images.githubusercontent.com/78383220/148603947-041a76bf-0ce5-4c83-af91-9a3a088c859d.PNG)

### Lettuce Class:

This class is for the lettuce object, the fourth veggie that appears on the screen! There is an array of 30 lettuce objects created in the frame.When hit, the object changes into a cut-up version of itself. 

![lettuce](https://user-images.githubusercontent.com/78383220/148604082-d8d72200-d788-4302-949b-d959db99b888.PNG)

### Onion Class:

This class is for the onion object, one of the veggies you are trying to slice! There is an array of 30 onion objects created in the frame. When hit, the object changes into a cut-up version of itself. 

![onion](https://user-images.githubusercontent.com/78383220/148604006-666c0c24-e46c-4095-af9f-96ec7ab6968e.PNG)

### Potato Class: 

This class is for the potato object, one of the slowest veggies. There is an array of 30 potato objects created in the frame. When hit, the object changes into a cut-up version of itself. 

![potato](https://user-images.githubusercontent.com/78383220/148603985-86d54a1d-5819-4060-bc2b-cde2b972b903.PNG)

### Strawberry Class:

This class is for the strawberry object! If it is hit by the knife, it will explode and return your score all the way back to zero! So be aware, and avoid the strawberry to get the highest score possible.

![strawberry](https://user-images.githubusercontent.com/78383220/148610162-b1aef06b-8cd0-494d-b5e1-594aba637a66.PNG)

### Knife Class:

This class is for the knife, one of the main objects in the game. The knife is connected to cursor in the frame. You use the knife to slice the veggies in order to earn points, but be aware of the starberry, because when hit, you score goes all the way back to zero! 

![knife](https://user-images.githubusercontent.com/78383220/148604268-de096ce7-e9d1-4a6c-8daa-d6c34f683b94.PNG)

### Background Class:

This is the class for the backgound, which makes the game come to life in a city setting, and it adds a visual aesthetic to the overalll game!

![background](https://user-images.githubusercontent.com/78383220/148604820-252230a2-089f-45f5-b7ae-792d8ed0f5bb.PNG)

## Methods

### Paint Method:

The paint method is a major part of the game as it paints all of the veggies in their respective arrays using a for loop. This method also includes the timing (60 second timer) and scoring used in the game!

![paint](https://user-images.githubusercontent.com/78383220/148606614-041c67ed-832d-4bf3-921e-dd0c0ead57c8.PNG)

### Collide Method:

The collide method is another crucial part of the game, as it determines whether or not the knife intersects the veggetable objects. If the objects intersect, then the score is updated, and the image of the original vegetable is changed to the cut-up version. 

![collide](https://user-images.githubusercontent.com/78383220/148606564-4e6d84bf-47c5-4feb-bf24-c654173a9a94.PNG)

### Respawn Method:

The respawn method is located in each respective veggetable class, and returns the objects to their starting position: the top but off screen.

![respawn](https://user-images.githubusercontent.com/78383220/148606637-db04df11-c2fd-4afa-a93a-1cdf3c75a566.PNG)

### Restart Method:

The restart method calls upon the respawn method for each veggie, and when the space key is pressed, the method is executed. Thsi method also resets the object to their original state. 

![restart](https://user-images.githubusercontent.com/78383220/148606584-ce742149-4543-484e-96cb-4e4274029f83.PNG)

## Help

Reopen or relaunch eclipse or the game if you run into any issues!

## Authors 

- Daniela Fisher: danielafisher05@gmail.com
- Vianne Schwaebe: vianneschwaebe@gmail.com

## Version History 

1. 0.1
   * Initial Release

