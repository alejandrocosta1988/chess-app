# Chess App

Chess App is being developed mainly to practice software development using the Java language, and a the Test Driven Development (TDD) discipline, under an agile perspective.

This application is being developed with basis on exercises available in several chapters of the book  *Agile Java* by Jeff Langr. This book was published back in 2005, and uses Java version 5. Although it's been around for a while, its content is super relevant and I recommend this book for everyone, who is learning Java or is interested in starting with a TDD approach to software development.

The book does not provide the code for the chess app, just requirements. This code is 100% by me. It's my personal solution to the problems presented throughout the book. It is not perfect, but I am doing my best, just like recommended by Kent Beck in XP Programming Explained. The exercises were planned and provided by Jeff Bay, and made the experience of reading this book much better. Thank you both Jeff Langr and Jeff Bay!

So, feel free to get in contact with me if you're interested in this book or if you have a very different solution that would like to show me. I will surely read your code and get in touch with you!

Who knows... maybe we could find some time to practice together by doing pair programming.

This project is still being developed. As the project evolves, I will add more information on its class structure, and functionalities.

## Functionalities

Since each production class of this project has its own test class, the best place to dive into to get an understanding of the project is the tests source code. You will find it with the same package structure of the production code under the test source folder.

Some of the functionalities that are implemented are listed below.

- There are seven types of pieces (pawn, knight, bishop, rook, queen, king, and no piece at all - to represent an empty square)). Each of these pieces has a score associated with it. The pawn has two kind of scores. It's worth  a higher score when there is no other pawn at the same file of the board. If there is at least one more pawn in the same file, any pawn in this file will be worth just half the score it would normally be.

- Each piece is represented by a single letter. If it is a black piece, the representation is done in upper case. If the piece is white, its representation is in lower case.

- Each piece implements a method to check if a move is legal or not. In chess, there are many rules related to the moves, so that's a challenge in this project. Currently, king and queen have this method implemented.

- A board can be created as an  empty board to allow putting given pieces at given places, so it would be possible to practice or study chess. But the board can also be set up ready for a game, with all its pieces at the correct places.

- It is possible to calculate the strength of each player by calculating the sum of the scores of black or white pieces on the board.

There are much more implemented functionalities, but there is no reason to dive into most of them. I wanted to highlight just the ones I consider more important or more relevant.

I am still struggling to be a professional developer, so have this in mind when you get to analyse this code. It's been a pleasure to work on this project, and to be with this great book at hands! Thank you Jeff Langr for all this work. Thank you Jeff Bay for the bulk of exercises that contains all the requirements of the chess application.
