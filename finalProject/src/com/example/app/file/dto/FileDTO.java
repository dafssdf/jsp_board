package com.example.app.file.dto;

//-- 서버에 저장되는 파일명
//file_system_name varchar(300) primary key,
//-- 원본 파일 명
//file_origin_name varchar(300),
//board_number int unsigned,
//constraint fk_file foreign key(board_number) 
//references tbl_board(board_number)
public class FileDTO {
	private String fileSystemName;
	private String fileOriginName;
	private int boardNumber;
	
	public FileDTO() {
	}

	public String getFileSystemName() {
		return fileSystemName;
	}

	public void setFileSystemName(String fileSystemName) {
		this.fileSystemName = fileSystemName;
	}

	public String getFileOriginName() {
		return fileOriginName;
	}

	public void setFileOriginName(String fileOriginName) {
		this.fileOriginName = fileOriginName;
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	@Override
	public String toString() {
		return "FileDTO [fileSystemName=" + fileSystemName + ", fileOriginName=" + fileOriginName + ", boardNumber="
				+ boardNumber + "]";
	}


	
	
}
