package example;

import java.util.ArrayList;
import java.util.List;

public class CandidateCode 
{ 

	public static List<Friend> friends = new ArrayList<Friend>();
	
	class Friend{
		private int currentPosition;
		private Friend previousFriend;
		private Friend nextFriend;
		
		int ballGetCounter = 0;

		public int getCurrentPosition() {
			return currentPosition;
		}
		public void setCurrentPosition(int currentPosition) {
			this.currentPosition = currentPosition;
		}
		public Friend getPreviousFriend() {
			return previousFriend;
		}
		public void setPreviousFriend(Friend previousFriend) {
			this.previousFriend = previousFriend;
		}
		public Friend getNextFriend() {
			return nextFriend;
		}
		public void setNextFriend(Friend nextFriend) {
			this.nextFriend = nextFriend;
		}
		public int getBallGetCounter() {
			return ballGetCounter;
		}
		public void setBallGetCounter(int ballGetCounter) {
			this.ballGetCounter = ballGetCounter;
		}



		Friend getNextNthFriend(int number){
			Friend f = null;
			while(number-- == 0){
				f = nextFriend.getNextNthFriend(number);
			}
			return f;
		}
	}
	
	public void initializeFriends(int numberOfFriends){
		for(int i=1; i<=numberOfFriends; i++){
			Friend f = new Friend();
			f.setCurrentPosition(i);
		}
	}
	
    public static int passCount(int numberOfFriends,int maxNumberOfTimePlayerReceiveBall,int numberOfPlacesBallPassLeftOrRight)
    {
    	
    	//initializeFriends(numberOfFriends);
    	int[] ballCounter = new int[numberOfFriends];
    	int passCounter = 0;
    	int passTo = 1;
    	while(checkAnyOneHasMoreThenMax(ballCounter, maxNumberOfTimePlayerReceiveBall) == -1){
    		passCounter++;
    		ballCounter[passTo - 1]++;
    		if(ballCounter[passTo - 1] % 2 == 0){
    			passTo = passTo + numberOfPlacesBallPassLeftOrRight;
    			if(passTo > numberOfFriends){
    				passTo = passTo % numberOfFriends;
    			}else if(passTo < 1){
    				passTo = passTo % numberOfFriends;
    			}
    			
    		}else{
    			passTo = passTo - numberOfPlacesBallPassLeftOrRight;
    			if(passTo > numberOfFriends){
    				passTo = passTo % numberOfFriends;
    			}else if(passTo < 1){
    				passTo = passTo % numberOfFriends;
    			}
    		}
    		
    	}
    	
    	
    	return passCounter;
    }
    
    public static int checkAnyOneHasMoreThenMax(int[] ballCounter, int maxNumber){
    	for(int i=0; i<ballCounter.length; i++){
    		if(ballCounter[i] > maxNumber){
    			return i;
    		}
    	}
    	return -1;
    }
    
    public static void main(String[] args) {
		CandidateCode cc = new CandidateCode();
		System.out.println(cc.passCount(5, 3, 2));
	}
}
