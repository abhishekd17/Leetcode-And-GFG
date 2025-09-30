class Solution {
    public boolean canTransform(String start, String result) {
        int n = start.length();
        
        int i = 0 , j = 0;
        while(i < n || j < n ){
            while(i < n && start.charAt(i) == 'X') i++;
            while(j < n && result.charAt(j) == 'X') j++;

            if(i >= start.length() || j >= result.length()) break;
            if(start.charAt(i) != result.charAt(j)) return false;
            if(start.charAt(i) == 'R' && i > j) return false;
            if(start.charAt(i) == 'L' && j > i) return false;
            i++;
            j++;
        }
        return i == j;
    }
}


// start = "RXXLRXRXL", result = "XRLXXRRLX"
// RXXLRXRXL
// XRLXXRRLX

// RX -- XR -- TRUE
// XL -- LX -- TRUE
// RX -- XR -- TRUE
// RX -- RL -- continue;
// XL -- LX -- TRUE;

// "RX XL RX R XL L LX"
// "XR LX XR R LX L XL"

// "XX XXXLXXXX"
// "LX XXXXXXXX"

// XL LR
// LX LX


// "RXXLRXRXL"
// "XRLXXRRLX"