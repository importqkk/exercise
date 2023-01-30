package ex230130;

public class LecturesDto {

	private int no;
	private String lecture;
	private String lecturer;
	private int hours;
	private int fee;
	
	public LecturesDto() {
		super();
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getLecture() {
		return lecture;
	}
	public void setLecture(String lecture) {
		this.lecture = lecture;
	}
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "LecturesDto [no=" + no + ", lecture=" + lecture + ", lecturer=" + lecturer + ", hours=" + hours
				+ ", fee=" + fee + "]";
	}
	
}
