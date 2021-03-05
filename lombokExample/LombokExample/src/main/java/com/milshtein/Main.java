package com.milshtein;

public class Main {
    public static void main(String[] args) {
//        SoccerPlayer player = new SoccerPlayer.SoccerPlayerBuilder("Alex", "Delpiero", "232323")
//                .age(24)
//                .agentName("Mino Raiola")
//                .team("Juventus")
//                .height(172)
//                .strongFoot(SoccerPlayer.Foot.RIGHT)
//                .build();
        SoccerPlayer player = new SoccerPlayer.SoccerPlayerBuilder()
                  .firstName("Alex")
                  .lastName("Delpiero")
                  .transferMarketId("232323")
                  .age(23)
                  .build();

//        SoccerPlayer player1 = new SoccerPlayer.SoccerPlayerBuilder("Alex", "Delpiero", "232323")
//                .age(24)
//                .agentName("Mino Raiola")
//                .team("Juventus")
//                .height(172)
//                .strongFoot(SoccerPlayer.Foot.RIGHT)
//                .build();
        SoccerPlayer player1 = new SoccerPlayer.SoccerPlayerBuilder()
                  .firstName("Alex")
                  .lastName("Delpiero")
                  .transferMarketId("232323")
                  .age(25)
                  .build();


        System.out.println(player);
        System.out.println(player.equals(player1));
    }
}
