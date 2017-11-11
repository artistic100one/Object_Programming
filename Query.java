package test;

import java.util.ArrayList;
import java.util.List;
import object_project.data_set;
public class Query {
   /*
    * input student ID(=SID) or locker ID(=LID), term of validity(=TOV)
    * return if input is SID, return is 0(=no match) or x(x > 0, x is LID which student who has the SID uses locker's)
    * return if input is LID, return is 0(=no one use it) or x(x is LID)
    * return if input is TOV, return is 0(=full of all locker) or x[](x[i] is LID )
    */
   public static List<data_set> list;
   
   public int search(String s, int num) {
      String st;
      if(num == 1)   //input is SID{
         for(int i = 0; i < list.size(); i++){
            st = list.get(i).getCustId();
            if(st.equals(s))
               return i;
         }
      if(num == 2)
         for(int i = 0; i < list.size(); i++){
            st = list.get(i).getCustLock();
            if(st.equals(s))
               return i;
         }
      if(num == 3){
         for(int i = 0; i < list.size(); i++){
            st = list.get(i).getCustPeriod();
            if(st.equals(s))
               return i;
         }
      }
      return -1;
   }
   
   /*
    * input data_set
    * return is 0(=match) or 1(=no match, insert into the target)
    */
   
   public int insert(data_set data) {
      if(search(data.getCustLock() , 2) > -1){
         System.out.println("이미 데이터가 존재합니다");
         return -1;
      }
      list.add(data);
      return 1;
   }
   
   /*
    * input data_set or LID
    * return is 0(=no match so send error message) or 1(=match send success message)
    */
   
   public int delete(data_set data) {
     int index = search(data.getCustLock(), 2);
      if(index > -1){
         list.remove(index);
         System.out.println("파일이 삭제되었습니다.");
         return 1;
      }
      System.out.println("파일이 존재하지 않습니다.");
      return -1;
   }
   
   /*
    * input data_set or LID plus new data_set or TOV or LID
    * return is 0(=no match so send error message) or 1(=match send success message)
    * First, search target
    * Second, if input is single data, copy the target and switch the data
    * or use new data_set
    * Third, delete previous data
    * Last, insert new data_set
    */
   
   public int modification(data_set data) {
     int index = search(data.getCustLock(), 2); 
     if(index > -1){
        list.get(index).setData_Set(data);
     }
      return 1;
   }
   
   public static void main() {
      
   }
   
   
}