package object_project;

public class data_set { //excel�� �־���� �����͵��� ��ġ�� ������ ������ structure class

	private String CustId; // �й�
	private String CustName; // �̸�
	private String CustNum; // �ڵ��� ��ȣ
	private String CustPeriod; // ������

	// data set about id,name,num,peroid
	public data_set(String CustId, String CustName, String CustNum, String CustPeriod) {
		super();
		this.CustId = CustId;
		this.CustName = CustName;
		this.CustNum = CustNum;
		this.CustPeriod = CustPeriod;
	}

	public String getCustId() {
		return CustId;
	}

	public void setCustId(String CustId) {
		this.CustId = CustId;
	}

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String CustName) {
		this.CustName = CustName;
	}

	public String getCustNum() {
		return CustNum;
	}

	public void setCustNum(String CustNum) {
		this.CustNum = CustNum;
	}

	public String getCustPeriod() {
		return CustPeriod;
	}

	public void setCustPeriod(String CustPeriod) {
		this.CustPeriod = CustPeriod;
	}

	// override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("ID : " + CustId);
		sb.append("ID : " + CustName);
		sb.append("ID : " + CustNum);
		sb.append("ID : " + CustPeriod);

		return sb.toString();
	}
}