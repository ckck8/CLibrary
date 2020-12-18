package dto;

import java.io.Serializable;

public class RentlogsDTO implements Serializable{
	private int rentId;
	private String rentDate;
	private String returnDate;
    private int bookId;
    private int staffId;

    //**********************************************************
    //コンストラクタ
    //**********************************************************
	public RentlogsDTO() {}
	public RentlogsDTO(int rentId, String rentDate,String returnDate,int bookId,int staffId) {
		this.rentId=rentId;
		this.rentDate=rentDate;
		this.returnDate=returnDate;
		this.bookId=bookId;
		this.staffId=staffId;

	}
	//**********************************************************
	//getter
	//**********************************************************
	public int getRentId() {
		return rentId;
	}
	public String getRentDate() {
		return rentDate;
	}
	public String getReturnDate(){
		return returnDate;
	}
	public int getBookId() {
		return bookId;
	}
	public int getStaffId() {
		return staffId;
	}

	//**********************************************************
	//setter
	//**********************************************************
	public void setRentId(int rentId) {
		this.rentId=rentId;
	}
	public void setRentDate(String rentDate) {
		this.rentDate=rentDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate=returnDate;
	}
	public void setBookId(int bookId) {
		this.bookId=bookId;
	}
	public void setStaffId(int staffId) {
		this.staffId=staffId;
	}


}
