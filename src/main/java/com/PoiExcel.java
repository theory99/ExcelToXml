package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class PoiExcel {
	
	public static void main(String[] args) throws IOException {
			Scanner in = new Scanner(System.in);
			while(true){
				System.out.println("请输入excel路径，路径格式例如：d:\\\\xx.xlsx");
				String excelAddress=in.next();
				System.out.println("上传的excel地址:"+excelAddress);
				System.out.println("正在生成xml文件......");
				readXlsx(excelAddress);
				System.out.println("xml文件生成结束");
			}
		
	}
	
	
	 private void readXls() throws IOException{  
		    InputStream is = new FileInputStream( "D:\\1.xls");  
		    HSSFWorkbook hssfWorkbook = new HSSFWorkbook( is);   
		      
		    // 循环工作表Sheet  
		    for(int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){  
		      HSSFSheet hssfSheet = hssfWorkbook.getSheetAt( numSheet);  
		      if(hssfSheet == null){  
		        continue;  
		      }  
		        
		      // 循环行Row   
		      for(int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++){  
		        HSSFRow hssfRow = hssfSheet.getRow( rowNum);  
		        if(hssfRow == null){  
		          continue;  
		        }  
		          
		        // 循环列Cell    
		        for(int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++){  
		          HSSFCell hssfCell = hssfRow.getCell( cellNum);  
		          if(hssfCell == null){  
		            continue;  
		          }  
		            
		          System.out.print("    " + getValue( hssfCell));  
		        }  
		        System.out.println();  
		      }  
		    }  
		  }  
		    
		  @SuppressWarnings("static-access")  
		  private String getValue(HSSFCell hssfCell){  
		    if(hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN){  
		      return String.valueOf( hssfCell.getBooleanCellValue());  
		    }else if(hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC){  
		      return String.valueOf( hssfCell.getNumericCellValue());  
		    }else{  
		      return String.valueOf( hssfCell.getStringCellValue());  
		    }  
		  }  
		  
	private static void readXlsx(String excel) throws IOException{
		File file = new File(excel);
		if(!file.exists()){
			System.out.println("excel地址错误!");
			return ;
		}
		//文件转XSSFWorkbook对象
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(excel);
		//sheet页数
		int sheets = xssfWorkbook.getNumberOfSheets();
		//循环工作表Sheet
		for(int numSheet = 0; numSheet < sheets; numSheet++){
			List<Entity> list = new ArrayList<Entity>();
			//sheet对象
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt( numSheet);
			if(xssfSheet == null){
				continue;
			}
			//行数
			int rows = xssfSheet.getLastRowNum();
			//循环行Row
			for(int rowNum = 1; rowNum <= rows; rowNum++ ){
				//获取一行对象
				XSSFRow xssfRow = xssfSheet.getRow( rowNum);
				if(xssfRow == null){
					continue;
				}
				//解析一行对象
				list.add(rowForEntity(xssfRow));
			}  
			createXml(list);
		}
	}
	
	/**
	 * 行对象转实体对象
	 * @param xssfRow
	 * @return
	 */
	private static Entity rowForEntity(XSSFRow xssfRow){
		Entity entity = new Entity();
		DecimalFormat df = new DecimalFormat("0");
		try {
			entity.setFpdm(df.format(xssfRow.getCell(0).getNumericCellValue()));//发票代码
		} catch (Exception e) {
			entity.setFpdm("发票代码解析异常");
		}
		try {
			entity.setFphm(df.format(xssfRow.getCell(1).getNumericCellValue()));//发票号码
		} catch (Exception e) {
			entity.setFphm("发票号码解析异常");//发票号码
		}
		try {
			short format = xssfRow.getCell(2).getCellStyle().getDataFormat();
            SimpleDateFormat sdf = null;
            if (format == 14 || format == 31 || format == 57 || format == 58
                    || (176<=format && format<=178) || (182<=format && format<=196)
                    || (210<=format && format<=213) || (208==format ) ) {// 日期
                sdf = new SimpleDateFormat("yyyyMMdd");
            }
            double value = xssfRow.getCell(2).getNumericCellValue();
            Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
            String result = sdf.format(date);
            entity.setKprq(result);
		} catch (Exception e) {
			entity.setFphm("开票日期解析异常");//开票日期
		}
		try {
			entity.setKhmc(xssfRow.getCell(4).getStringCellValue());//客户名称
		} catch (Exception e) {
			entity.setKhmc("客户名称解析异常");//客户名称
		}
		try {
			entity.setKpje(xssfRow.getCell(5).getNumericCellValue()+"");//开票金额
		} catch (Exception e) {
			entity.setKpje("开票金额解析异常");//开票金额
		}
		try {
			entity.setZfbz(xssfRow.getCell(6).getNumericCellValue()==1?"正常":"作废");
		} catch (Exception e) {
			entity.setZfbz("1");
		}
		try {
			entity.setSl(df.format(xssfRow.getCell(8).getNumericCellValue()));//数量
		} catch (Exception e) {
			entity.setSl("1");//数量
		}
		return entity;
	}
	
	/**
	 * 生成xml
	 * @param list
	 * @throws IOException
	 */
	private static void  createXml(List<Entity> list) throws IOException{
		Element root = DocumentHelper.createElement("ROOT");
		Document document = DocumentHelper.createDocument(root);
		Element element1 = root.addElement("UPINVINFO").addAttribute("class", "UPINVINFO");
		Element element2 =element1.addElement("BASEINFO").addAttribute("class", "BASEINFO").addAttribute("Version", "1.0");
		element2.addElement("NSRSBH").addText("330201744993850");
		element2.addElement("NSRMC").addText("中国电信股份有限公司宁波分公司");
		Element element3 = element1.addElement("FPHZXX_JLS").addAttribute("class", "FPHZXX_JL").addAttribute("size", list.size()+"");
		for(int i=0;i<list.size();i++){
			Entity entity = list.get(i);
			Element element4 = element3.addElement("FPHZXX_JL");
			Element element5 = element4.addElement("FPHZXX").addAttribute("class", "FPHZXX");
			element5.addElement("WYM");
			element5.addElement("FPDM").addText(entity.getFpdm());
			element5.addElement("FPHM").addText(entity.getFphm());
			element5.addElement("YFPDM").addText("有效证明");
			element5.addElement("YFPHM").addText("有效证明");
			element5.addElement("KPRQ").addText(entity.getKprq());
			element5.addElement("FKFDM");
			element5.addElement("FKFMC").addText(entity.getKhmc());
			element5.addElement("FKTKZT").addText(entity.getZfbz());
			element5.addElement("DBFPSL").addText(entity.getSl());
			element5.addElement("SPHSL").addText("1");
			element5.addElement("SPHJJE").addText(entity.getKpje());
			element5.addElement("SJKPJE").addText(entity.getKpje());
		}
		OutputFormat format = new OutputFormat("    ",true);
		format.setEncoding("UTF-8");//设置编码格式 
		int fileCount=1;
		String fileName = fileExist(fileCount);
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(fileName),format);
		System.out.println("生成的xml地址："+fileName);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	/**
	 * 递归判断文件是否存在
	 * @param i
	 * @param fileName
	 */
	private static String fileExist(int i){
		Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String fileName = "d:\\TAX_FPXX_"+dateFormat.format(date)+"_330201744993850_"+i+".xml";
		File file = new File(fileName);
		if(file.exists()){
			i = i+1;
			fileName = "d:\\TAX_FPXX_"+dateFormat.format(date)+"_330201744993850_"+i+".xml";
			return fileExist(i);
		}
		return fileName;
	}
}
