package com.milshtein;

import lombok.Builder;
import lombok.Data;

@Data
@Builderiyfiufuygoiugoi
public class SoccerPlayer {
    private final String firstName;
    private final String lastName;
    private final String transferMarketId;
    private int age;
    private String team;
    private int height;
    private Foot strongFoot;
    private String agentName;
    public enum Foot {
        RIGHT, LEFT
    }

//    public SoccerPlayer(SoccerPlayerBuilder builder) {
//        this.firstName = builder.firstName;
//        this.lastName = builder.lastName;
//        this.transferMarketId = builder.transferMarketId;
//        this.age = builder.age;
//        this.team = builder.team;
//        this.height = builder.height;
//        this.strongFoot = builder.strongFoot;
//        this.agentName = builder.agentName;
//    }
//
//    public static class SoccerPlayerBuilder {
////        private final String firstName;
////        private final String lastName;
////        private final String transferMarketId;
//        private String firstName;
//        private String lastName;
//        private String transferMarketId;
//        private int age;
//        private String team;
//        private int height;
//        private Foot strongFoot;
//        private String agentName;
//
//        public SoccerPlayerBuilder(String firstName, String lastName, String transferMarketId){
//            this.firstName = firstName;
//            this.lastName = lastName;
//            this.transferMarketId = transferMarketId;
//        }
//
//        public SoccerPlayerBuilder age(int age){
//            this.age = age;
//            return  this;
//        }
//
//        public SoccerPlayerBuilder team(String team){
//            this.team = team;
//            return  this;
//        }
//
//        public SoccerPlayerBuilder height(int height){
//            this.height = height;
//            return  this;
//        }
//
//        public SoccerPlayerBuilder strongFoot(SoccerPlayer.Foot strongFoot){
//            this.strongFoot = strongFoot;
//            return  this;
//        }
//
//        public SoccerPlayerBuilder agentName(String agentName){
//            this.agentName = agentName;
//            return  this;
//        }
//
//        public SoccerPlayer build(){
//           return  new SoccerPlayer(this);
//        }
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
////    public  void setFirstName(String firstName) {
////        this.firstName = firstName;
////    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
////    public  void setLastName(String lastName) {
////        this.lastName = lastName;
////    }
//
//    public String getTransferMarketId() {
//        return transferMarketId;
//    }
//
////    public  void setTransferMarketId(String transferMarketId) {
////        this.transferMarketId = transferMarketId;
////    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getTeam() {
//        return team;
//    }
//
//    public void setTeam(String team) {
//        this.team = team;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public Foot getStrongFoot() {
//        return strongFoot;
//    }
//
//    public void setStrongFoot(Foot strongFoot) {
//        this.strongFoot = strongFoot;
//    }
//
//    public String getAgentName() {
//        return agentName;
//    }
//
//    public void setAgentName(String agentName) {
//        this.agentName = agentName;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        //List<SoccerPlayer> list = new ArrayList<>();
//        //list.remove(o);
//        if(this == o) return true;
//        if(!(o instanceof SoccerPlayer)) return false;
//        SoccerPlayer that = (SoccerPlayer) o;
//        return firstName.equals(that.firstName) && lastName.equals(that.lastName) && transferMarketId.equals(that.transferMarketId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName, lastName, transferMarketId);
//    }
//
//    @Override
//    public String toString() {
//        System.out.println(this);
//        return "SoccerPlayer{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", transferMarketId='" + transferMarketId + '\'' +
//                ", age=" + age +
//                ", team='" + team + '\'' +
//                ", height=" + height +
//                ", strongFoot=" + strongFoot +
//                ", agentName='" + agentName + '\'' +
//                '}';
//    }
}
