class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
            int[] result =new int[numberOfUsers];
            int[] offlineTime=new int[numberOfUsers];

              events.sort((a, b) -> {
                int timeA = Integer.parseInt(a.get(1));
                int timeB = Integer.parseInt(b.get(1));
                int timeCompare = Integer.compare(timeA, timeB);
                if (timeCompare != 0) {
                    return timeCompare;
                }
                return b.getFirst().compareTo(a.getFirst());
            });
            for(List<String> event:events){
                System.out.print(event.get(1));
                String type=event.get(0);
                if(type.equals("MESSAGE")){
                    processMessage(event,result, offlineTime);
                }
                else{
                    processOffline(event, offlineTime);
                }
            }
            return result;
        }
    private void processMessage(List<String> event, int[] result, int[] offlineTime){
        String type= event.get(2);
        int time= Integer.parseInt(event.get(1));
        if(type.equals("ALL")){
            for(int i=0;i<result.length;i++){
                result[i]++;
            }
        }
        else if(type.equals("HERE")){
            for(int i=0;i<result.length;i++){
                if(offlineTime[i]==0){
                    result[i]++;
                }
                else if(offlineTime[i]+60<=time){
                    result[i]+=1;
                    offlineTime[i]=0;
                }
            }
        }
        else{
            String[] mentions= event.get(2).split(" ");
            for(String m: mentions){
                int userId= Integer.parseInt(m.substring(2));
                result[userId]++;
            }
        }
    }
     private void processOffline(List<String> event, int[] offlineTime){
        int userId= Integer.parseInt(event.get(2));
        offlineTime[userId]= Integer.parseInt(event.get(1));
    }
}