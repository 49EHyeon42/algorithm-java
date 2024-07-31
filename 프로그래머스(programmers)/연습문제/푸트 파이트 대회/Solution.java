class Solution {
    
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            if (food[i] == 1) {
                continue;
            }
            
            int maxIndex = food[i] / 2;
            
            for (int j = 0; j < maxIndex; j++) {
                sb.append(i);
            }
        }
        
        sb.append(0);
        
        for (int i = food.length - 1; i > 0; i--) {
            if (food[i] == 1) {
                continue;
            }
            
            int maxIndex = food[i] / 2;
            
            for (int j = 0; j < maxIndex; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
