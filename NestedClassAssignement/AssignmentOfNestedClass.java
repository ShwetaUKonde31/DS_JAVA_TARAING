import java.time.LocalDate;



public class AssignmentOfNestedClass {
  public static void main(String[] args) {
	  WatchMovie WatchMovie =new WatchMovie();
	  WatchMovie.PrintYourTicket movie1=new WatchMovie.PrintYourTicket();
	  WatchMovie.PrintYourTicket movie2=new WatchMovie.PrintYourTicket();
	  
	  WatchMovie.buyTicketBefore(true);
	  movie1.setMovieName("Rocketry");
      movie1.setMovietime(LocalDate.now());
	  movie1.setSeatnumber("C1");
	  movie1.setTicketprice(240);
	  movie1.displaymovieD();
	  System.out.println("-----------------");
	  
	  WatchMovie.buyTicketOnInvalidTimeOfShow(true);
	  movie2.setMovieName("K.G.F.");
      movie2.setMovietime(LocalDate.now());
	  movie2.setSeatnumber("F12");
	  movie2.setTicketprice(240);
	  movie2.displaymovieD();
	  System.out.println("-----------------");
	  
	  
	  
	  
	  
	
}
}

class WatchMovie{
	private BookYourTicket mhall = new BookYourTicket(false,true);
	  void buyTicketBefore(boolean isAvaible){
		 System.out.println("Hurry up...Movie tickets are about to end");
		 mhall.setTicketAvaible(isAvaible);
	  }
	  
	  void buyTicketOnInvalidTimeOfShow(boolean buymeatime){
            if(buymeatime==false){
            	throw new RuntimeException("Sorry u are late ..all seats are full");

	        }else{
	        	System.out.println("Ohh u are lucky one 1 seat is avaiable..!!");
	      }

	  }
	  void buyTicketMeanTimeOfShow(boolean isAvaible){
		  System.out.println("Sorry movie time is mismatched..!!");
		  mhall.setTicketAvaible(isAvaible);
		  
	  }
	  private class BookYourTicket{

	        boolean isTicketAvaible; //false
			boolean isValidEnterTime;// false;
			
			public BookYourTicket(boolean isTicketAvaible, boolean isValidEnterTime) {
				super();
				this.isTicketAvaible = isTicketAvaible;
				this.isValidEnterTime = isValidEnterTime;
			}
			public boolean isTicketAvaible() {
				return isTicketAvaible;
			}
			public void setTicketAvaible(boolean isTicketAvaible) {
				this.isTicketAvaible = isTicketAvaible;
			}
			public boolean isValidEnterTime() {
				return isValidEnterTime;
			}
			public void setValidEnterTime(boolean isValidEnterTime) {
				this.isValidEnterTime = isValidEnterTime;
			}
			

		  
	  }
	  public static class PrintYourTicket{
		  
		  LocalDate movietime;
          String movieName;
          int ticketprice;
          String seatnumber;
          public LocalDate getMovietime() {
			return movietime;
		}
		public void setMovietime(LocalDate localDate) {
			this.movietime = localDate;
		}
		public String getMovieName() {
			return movieName;
		}
		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}
		public int getTicketprice() {
			return ticketprice;
		}
		public void setTicketprice(int ticketprice) {
			this.ticketprice = ticketprice;
		}
		public String getSeatnumber() {
			return seatnumber;
		}
		public void setSeatnumber(String seatnumber) {
			this.seatnumber = seatnumber;
		}
	
		void displaymovieD() {
			System.out.println("MovieTime :"+movietime);
			System.out.println("Movie name :"+movieName);
			System.out.println("SeatNumber :"+seatnumber);
			System.out.println("Ticket price :"+ticketprice);
		}
		
		
         
		  
	  }
}

/*
              WatchMovie
                has BookYourTicket as a private nested class
                PrintTicket is ticket is called by WatchMovie.PrintYourTicket
 */
