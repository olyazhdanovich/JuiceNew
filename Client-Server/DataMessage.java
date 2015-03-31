import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
	
public class DataMessage implements JSONAware {
	static int currId = 1;
        private String userName;
	private int id;
	private String text;
	private boolean isDeleted = false;
	private boolean isChanged = false;
	
	public DataMessage() {
		userName = "1";
		text = "";
		id = currId++;
	}
	public DataMessage(String text,String userName) {
		this.userName = userName;
		this.text = text;
		id = currId++;
	}
	public void setID(int id) {
		this.id = id;
	}
	public void setDelete(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public void setChange(boolean isChanged) {
		this.isChanged = isChanged;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getNameUser() {
		return userName;
	}
	public int getID() {
		return id;
	}
	public String getText() {
		return text;
	}
	public boolean getDelete() {
		return isDeleted;
	}
	public boolean getChange() {
		return isChanged;
	}
	
	public void deleteMessage() {
		if(isDeleted != true) {
			this.text = "message has isDeleted.";
			this.setDelete(true);
		}
	}
	
	public static DataMessage parseDataMessage(JSONObject obj){
		DataMessage info = new DataMessage();
		if((String)obj.get("user") != null) {
		info.userName = (String)obj.get("user");
		}
		info.text = (String)obj.get("message");
		info.id = Integer.parseInt(obj.get("id").toString());
		return info;
	}	
	@Override
	public String toJSONString(){
		JSONObject obj = new JSONObject();
		obj.put("user", userName);
		obj.put("message", text);
		obj.put("id", id);
		return obj.toString();
	}
	@Override
	public String toString(){
		return userName+" : "+text;
	}
	@Override
	public boolean equals(Object obj){
		return (((DataMessage)obj).getID()==id);
	}
   
}
