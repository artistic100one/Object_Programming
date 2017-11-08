/*
** ���� �Ŀ� Ŀ��Ʈ �ۼ��� ���� **

	* ���α׷� �帧 *
		1. ������ �Է��� ���� �˻��� ��ŭ searcheed ������ ���� 1 ����. (searcheed = �˻��� ������ ����)
		2. ������Ʈ�� InputStream���� ���� �� �ึ�� ���� ����� ����ڰ� �Է��� �˻�� ��
		3. �� ���� ������ ��ġ�Ҷ����� nowSearch ������ ���� 1 ���� (nowSearch = ��ġ�� �˻����� ����)
		4. ���� nowSearch �� searcheed�� ��ġ�� ��� �� ���� ����ڰ� ���ϴ� �˻����
		5. ������Ʈ�� �ִ� �ุŭ �迭�� ����� �� �迭�ȿ��� �˻������ ��ġ�ϴ� ���� ��ȣ�� ����

*/
package object_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Search {
	static int searcheed = 0;
	static String[] Cust = new String[4];

	Search(List<data_set> list) {
		
		try {
			FileInputStream fis = new FileInputStream("D:\\db.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			data_set ds = list.get(0);			
			int SearchArray[] = new int[rows];
			int ArrayNum = 0;
			int nowSearch = 0;
			for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
				nowSearch = 0;
				XSSFRow row = sheet.getRow(rowIndex); // �� ���� �о�´�
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();
					for (int columnIndex = 0; columnIndex < cells; columnIndex++) {
						XSSFCell cell = row.getCell(columnIndex); // ���� ����ִ� ���� �д´�.
						
						if(columnIndex == 0) {
							if(ds.getCustId().equals(String.valueOf(new Double(cell.getNumericCellValue()).intValue()))) {
								nowSearch ++;
							}
						}
						else if(columnIndex == 1) {
							if(ds.getCustName().equals(cell.getStringCellValue())) {
								nowSearch ++;
							}
						}
						else if(columnIndex == 2) {
			
							if(ds.getCustNum().equals(String.valueOf(new Double(cell.getNumericCellValue()).intValue()))) {
								nowSearch ++;
							}
						}	
						else if(columnIndex == 3) {
							if(ds.getCustPeriod().equals(String.valueOf(new Double(cell.getNumericCellValue()).intValue()))) {
								nowSearch ++;
							}
						}
						if(nowSearch == searcheed) {
							SearchArray[ArrayNum] = rowIndex;
							ArrayNum ++;
							nowSearch = 0;
						}
					}
				}
			}
			System.out.println("�˻� ��� :");
			for(int i=0; i<ArrayNum; i++) {
				System.out.println(SearchArray[i]);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�й��� �Է����ּ���");
		Cust[0] = sc.next(); 
		if(!Cust[0].equals("0")) {
			searcheed ++;
		}
		System.out.println("�̸��� �Է����ּ���");
		Cust[1] = sc.next(); 
		if(!Cust[1].equals("0")) {
			searcheed ++;
		}		
		System.out.println("����ó�� �Է����ּ��� (- ����)");
		Cust[2] = sc.next(); 
		if(!Cust[2].equals("0")) {
			searcheed ++;
		}				
		System.out.println("��� ������ �Է����ּ��� (yymmdd ��������)");
		Cust[3] = sc.next(); 
		if(!Cust[3].equals("0")) {
			searcheed ++;
		}

		List<data_set> list = new ArrayList<data_set>(); // create list object
		list.add(new data_set(Cust[0],Cust[1], Cust[2],Cust[3])); // add in list id,name,num,peroid 
		
		Search ser = new Search(list);
	}
}