
public class FunctionInovation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DairyCollection dairy =new DairyCollection();
		dairy.startCollectMilk();
        dairy.calculateplantsCollection(60, 70);
        System.out.println(dairy.avarageMilkCollection(60,70));
        System.out.println(dairy.avaragecostofmilk());
       

	}

}

class DairyCollection{
	float collection;
	 void startCollectMilk() {
		 System.out.println("Started the milk collection");
	 }
	 void calculateplantsCollection(int plant1,int plant2) {
		 collection=plant1+plant2;
		 System.out.println("Total milk collection \n "+collection);
		 
	 }
	 float avarageMilkCollection(int plant1,int plant2) {
		 System.out.println("Avarage milk collection");
		 return (plant1+plant2)/2;
		 
	 }
	 double avaragecostofmilk() {
		 System.out.println("Total cost of milk collection");
		 return collection*30;
	 }
}


