

public class WhatsAppAsscoiation {
  public static void main(String[] args) {
	    StoryFeature stf = new StoryFeature("Highpoplarity");
	    Tag t=new Tag("Sighgad","Vivek");
	    Image i=new Image("900kb","jpg");
	    WhatsApp whtsApp =new WhatsApp("4.4", "Enterinment", "12.6mb", stf, 12);
	    
	    whtsApp.printApp();
	    System.out.println("***********Story Summery***********");
        Story story  = whtsApp.upload(t, i);
	    story.printViews();
	  //  whtsApp.upload(t,i);
	   
	    
		
}
}
class App{
	
	String rating;
	String typeOfApp;
	String size;
	public App(String rating, String typeOfApp, String size) {
		super();
		this.rating = rating;
		this.typeOfApp = typeOfApp;
		this.size = size;
	}
	void printApp() {
		System.out.println("+----APP INFO----------");
		System.out.println("|Category of app : "+typeOfApp);
		System.out.println("|Rating   : "+rating);
		System.out.println("|Size     : "+size);
		System.out.println("+-----------------------");
	}
	
	
}


class WhatsApp extends App //isA
{
	StoryFeature stryFeat; //hasA
	int numberOfgroups; //front load, top load
	
	public WhatsApp(String rating, String typeOfApp, String size, StoryFeature stryFeat, int numberOfgroups) {
		super(rating, typeOfApp, size);
		this.stryFeat = stryFeat;
		this.numberOfgroups = numberOfgroups;
	}
	
	Story upload(Tag t,Image i) {
		System.out.println("Tagged person "+t.person);
		System.out.println("Image size "+i.imageSize);
		Story story= new Story("#sighgadtrip","jpg","100M");
		return story;
	}
		
}

class StoryFeature{
	String popularity;

	public StoryFeature(String popularity) {
		super();
		this.popularity = popularity;
	}
	
	
}
 class Story{
	 String tag;
	 String imageT;
	 String views;
	public Story(String tag, String imageT, String views) {
		super();
		this.tag = tag;
		this.imageT = imageT;
		this.views = views;
	}
	public void printViews() {
	    System.out.println("Hashtag "+tag);
		System.out.println("Number of views "+views);
		
	}
	
	

	
	 
 }
 
 
 class Tag{
	 String location;
	 String person;
	public Tag(String location, String person) {
		super();
		this.location = location;
		this.person = person;
	}
	 
 }
 class Image{
	 String imageSize;
	 String imageExtension;
	public Image(String imageSize, String imageExtension) {
		super();
		this.imageSize = imageSize;
		this.imageExtension = imageExtension;
	}
	 
	 
 }

