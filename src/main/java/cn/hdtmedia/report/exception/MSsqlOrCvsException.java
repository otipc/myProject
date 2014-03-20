package cn.hdtmedia.report.exception;

public class MSsqlOrCvsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errCode;
	private String errMsg;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public MSsqlOrCvsException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

}
