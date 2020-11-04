package com.serch.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.serch.Util.DateChooser;
import com.serch.Util.JDBCUtil;
import com.serch.Util.JDBCUtilX;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class mainY extends JFrame {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private static Properties prop = new Properties();
	public static InputStream inputStream;
	public static BufferedReader bf;
	static mainY ss;
	static {
		try {
			// System.out.println(System.getProperty("user.home"));//获取系统根目录
			// System.out.println(System.getProperty("user.dir"));//获取工程目录
			inputStream = mainY.class.getClassLoader().getResourceAsStream("db.pro");
			// inputStream = new FileInputStream(".\lib\db.pro");
			bf = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			prop.load(bf);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	List<String> listValue;
	String str;
	String sql1 = "";
	List<String> list = new ArrayList<>();
	JDBCUtil jdbc = new JDBCUtil();
	JDBCUtilX jdbcx = new JDBCUtilX();
	final DateChooser mp = new DateChooser("yyyy-MM-dd");
	// JFrame jf = new JFrame("填报率和响应率");
	private JButton jb;
	private JButton dt;
	private JButton reload;
	private JButton cancel;
	private JLabel label1;
	private JLabel label2;
	private Font font1;
	private JComboBox<String> cmb;
	private Integer month;
	private Integer year;
	private Integer day;
	private String i;
	Integer excTime;
	Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
	Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
	Map<Integer, Integer> map3 = new HashMap<Integer, Integer>();
	Map<Integer, Integer> map4 = new HashMap<Integer, Integer>();
	Map<Integer, Integer> map5 = new HashMap<Integer, Integer>();
	Map<Integer, Integer> map6 = new HashMap<Integer, Integer>();
	Map<Integer, Integer> map7 = new HashMap<Integer, Integer>();
	Map<Integer, Integer> map8 = new HashMap<Integer, Integer>();
	Map<Integer, Integer> map9 = new HashMap<Integer, Integer>();

	Map<Integer, Integer> tmap1 = new HashMap<Integer, Integer>();
	Map<Integer, Integer> tmap2 = new HashMap<Integer, Integer>();
	Map<Integer, Double> tmap3 = new HashMap<Integer, Double>();
	Map<Integer, Double> tmap4 = new HashMap<Integer, Double>();
	Map<Integer, Double> tmap5 = new HashMap<Integer, Double>();
	Map<Integer, Double> tmap6 = new HashMap<Integer, Double>();
	String A1 = prop.getProperty("sql1_name");
	String A2 = prop.getProperty("sql2_name");
	String A3 = prop.getProperty("a1_name");
	String A4 = prop.getProperty("a2_name");
	String A5 = prop.getProperty("a3_name");
	String A6 = prop.getProperty("a4_name");
	String A7 = prop.getProperty("a5_name");
	String A8 = prop.getProperty("a6_name");
	String A9 = prop.getProperty("a7_name");
	String B1 = prop.getProperty("b1_name");
	String B2 = prop.getProperty("b2_name");
	String B3 = prop.getProperty("b3_name");
	String B4 = prop.getProperty("b4_name");
	String B5 = prop.getProperty("b5_name");
	String B6 = prop.getProperty("b6_name");
	LinkedHashMap<String, String> json = new LinkedHashMap<String, String>();
	JLabel labeljson = new JLabel("");    //创建标签
	
	@SuppressWarnings("unchecked")
	public void mathQ() {		
		String jsonStr = prop.getProperty("qtMap");
		//转为LinkedHashMap<String, Object>  此步骤必须
		json = JSON.parseObject(jsonStr,LinkedHashMap.class,Feature.OrderedField);
		
	}
	
	public mainY() {
		mathQ();
		shezhi();// 设置程序窗口
		UpPanel();// 上部分布局
		Center();//中间部分布局
		DownPanel();// 下部分布局
		// MidPanel();
		event();// 监听
		//this.repaint();
	}

	private void UpPanel() {
		JPanel up = new JPanel(); // 创建上面的JPabel
		label1 = new JLabel("截止到");
		label2 = new JLabel("00:00:00");
		up.add(label1);
		up.add(mp);
		up.add(label2);
		label1.setForeground(Color.BLUE);
		label2.setForeground(Color.BLUE);
		this.add(up, BorderLayout.NORTH);
		this.setVisible(true);
	}
	private void Center() {
        JPanel center=new JPanel();    //创建中间的JPabel
        JLabel label1=new JLabel("五色清单：");    //创建标签
        String k = null;
        label1.setForeground(Color.BLUE);
        labeljson.setForeground(Color.BLUE);
        cmb =new JComboBox<String>();    //创建JComboBox
        for(String key:json.keySet()){
        	k = key;
			cmb.addItem(key);//向下拉列表中添加一项
		}
        cmb.setSelectedItem(k);
        labeljson.setText(json.get(k));
        center.add(label1);
        center.add(cmb);
        center.add(labeljson);
        this.add(center);
        this.add(center);
        this.setVisible(true);
	
	}
	

	private void DownPanel() {
		JPanel down = new JPanel(); // 创建下面的JPabel
		font1 = new Font("SansSerif", Font.BOLD, 15);
		jb = new JButton("查询");
		dt = new JButton("导出");
		dt.setEnabled(false);
		reload = new JButton("加载");
		cancel = new JButton("关闭");
		jb.setFont(font1);
		dt.setFont(font1);
		down.add(jb);
		down.add(dt);
		down.add(reload);
		down.add(cancel);
		this.add(down, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	private void event() {
		this.reload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					prop.load(bf);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ss.reload();
				
			}
			
		});
		this.cmb.addItemListener(new ItemListener() {//为college下拉框设置监听器
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		    	labeljson.setText(json.get(cmb.getSelectedItem().toString()));
		    	jb.setEnabled(true);
		    }
		});
		this.jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JProgressBar pro = new JProgressBar();
				pro.setIndeterminate(false);

				long startTime = System.currentTimeMillis();// 记录开始时间
				dt.setEnabled(true);
				jb.setEnabled(false);
				/*
				 * for (String key : map.keySet()) { System.out.println("key= "+
				 * key + " and value= " + map.get(key)); }
				 * 
				 * #10：2019年整理情况 2020.1-2020.3 #20：2020年第一季度 2020.4-2020.6
				 * #30：2020年第二季度 2020.7-2020.9 #40：2020年第三季度 2020.10-2020.12
				 */
				String time = mp.showdd();
                i = cmb.getSelectedItem().toString();
                System.out.println(i);
				map3 = jdbcx.sql_a1(time);// 主表问题应回答数 A3
				map4 = jdbcx.sql_a2(time);// 主表问题实际回答数 A4
				map5 = jdbcx.sql_a3(time);// 主表问题实际关闭数 A5
				map6 = jdbcx.sql_a4(time);// 子表问题应回答数 A6
				map7 = jdbcx.sql_a5(time);// 子表问题已回答数 A7
				map1 = jdbc.sql1(i);// 五色清单应响应企业 A1
				map2 = jdbc.sql2(i);// 五色清单已响应企业 A2
				map8 = jdbcx.sql_a6(time);// 子表问题满意度回复基数（分母）A8
				map9 = jdbcx.sql_a7(time);// 子表问题满意度回复满意数（分子）A9

				year= mp.year;
				month = mp.month;
				day = mp.day;
				
				System.out.println(year+" "+month);
				String lastime = year + "-" + (month - 1) + "-01";
				String firstime = year + "-" + month + "-01";
				String nextime = year + "-" + (month + 1) + "-01";
				String firstyear = year + "-01-01";
				String nextyear = year + 1 + "-01-01";
				System.out.println(lastime + " " + firstime + " " + nextime + " " + firstyear + " " + nextyear);

				//查询特殊的日期时2021-01-01/2020-11-01
				tmap1 = jdbcx.sql_b1(firstime, time);// 本月填报家数
				tmap2 = jdbcx.sql_b2();// 应填报企业数
				tmap3 = jdbcx.sql_b3(lastime, firstime, time);// 上期发货金额
				tmap4 = jdbcx.sql_b4(nextyear, firstyear, time);// 本年累计金额
				tmap5 = jdbcx.sql_b5(nextime, firstime, time);// 本月累计金额
				tmap6 = jdbcx.sql_b6(firstime,nextime,time);// 本期发货金额
				long endTime = System.currentTimeMillis();// 记录结束时间
				excTime = (int) ((endTime - startTime) / 1000);
				JOptionPane.showMessageDialog(null, "查询共计用时约"+excTime+"秒");  

			}
		});

		this.dt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					WorkbookSettings settings = new WorkbookSettings();
					settings.setEncoding("UTF-8");
					File f = new File("响应率和填报率的基础数据" + mp.showdd() + ".xlsx");
					WritableWorkbook workbook = Workbook.createWorkbook(f);
					WritableSheet sheet = workbook.createSheet("响应率基础数据", 0);
					WritableSheet tSheet = workbook.createSheet("填报率基础数据", 0);
					WorkbookSettings workbookSettings = new WorkbookSettings();
					// 可以设置为UTF-8或者GBK或者ISO-8859-1
					workbookSettings.setEncoding("GBK");
					
					jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#.##"); //设置bai数字格式
					jxl.write.WritableCellFormat wcfN = new jxl.write.WritableCellFormat(nf); //设置表单格式
					
					// jxl.Workbook rwb =
					// Workbook.getWorkbook(in,workbookSettings);
					// Workbook wb =
					// workbook.getWorkbook(inputStream,workbookSettings);
					sheet.addCell((WritableCell) new Label(0, 0, A3));
					sheet.addCell((WritableCell) new Label(3, 0, A4));
					sheet.addCell((WritableCell) new Label(6, 0, A5));
					sheet.addCell((WritableCell) new Label(9, 0, A6));
					sheet.addCell((WritableCell) new Label(12, 0, A7));
					sheet.addCell((WritableCell) new Label(15, 0, A1));
					sheet.addCell((WritableCell) new Label(18, 0, A2));
					sheet.addCell((WritableCell) new Label(21, 0, A8));
					sheet.addCell((WritableCell) new Label(24, 0, A9));
					tSheet.addCell((WritableCell) new Label(0, 0, B1));
					tSheet.addCell((WritableCell) new Label(4, 0, B2));
					tSheet.addCell((WritableCell) new Label(13, 0, B3));
					tSheet.addCell((WritableCell) new Label(17, 0, B4));
					tSheet.addCell((WritableCell) new Label(21, 0, B5));
					tSheet.addCell((WritableCell) new Label(29, 0, B6));
					// System.out.println(A1);
					// System.out.println(A2);
					int i1 = 0;
					int i2 = 0;
					int i3 = 0;
					int i4 = 0;
					int i5 = 0;
					int i6 = 0;
					int i7 = 0;
					int i8 = 0;
					int i9 = 0;
					int o1 = 0;
					int o2 = 0;
					int o3 = 0;
					int o4 = 0;
					int o5 = 0;
					int o6 = 0;

					
					
					//Double b2 = 1000634179.940000;
					//格式化数值
					//tSheet.addCell(new jxl.write.Number(2, 0, b1, wcfNN)); //在表单中添加格式化的数字
					
					
					
					
					
					for (Integer key : map3.keySet()) {
						i1++;
						Integer value = map3.get(key);
						sheet.addCell(new jxl.write.Number(0, i1,  key));
						sheet.addCell(new jxl.write.Number(1, i1,  value));
					}
					for (Integer key : map4.keySet()) {
						i2++;
						Integer value = map4.get(key);
						sheet.addCell(new jxl.write.Number(3, i2,  key));
						sheet.addCell(new jxl.write.Number(4, i2,  value));
					}
					for (Integer key : map5.keySet()) {
						i3++;
						Integer value = map5.get(key);
						sheet.addCell(new jxl.write.Number(6, i3,  key));
						sheet.addCell(new jxl.write.Number(7, i3,  value));
					}
					for (Integer key : map6.keySet()) {
						i4++;
						Integer value = map6.get(key);
						sheet.addCell(new jxl.write.Number(9, i4,  key));
						sheet.addCell(new jxl.write.Number(10, i4,  value));
					}
					for (Integer key : map7.keySet()) {
						i5++;
						Integer value = map7.get(key);
						sheet.addCell(new jxl.write.Number(12, i5,  key));
						sheet.addCell(new jxl.write.Number(13, i5,  value));
					}
					for (Integer key : map1.keySet()) {
						i6++;
						Integer value = map1.get(key);
						sheet.addCell(new jxl.write.Number(15, i6,  key));
						sheet.addCell(new jxl.write.Number(16, i6,  value));
					}
					for (Integer key : map2.keySet()) {
						i7++;
						Integer value = map2.get(key);
						sheet.addCell(new jxl.write.Number(18, i7,  key));
						sheet.addCell(new jxl.write.Number(19, i7,  value));
					}
					for (Integer key : map8.keySet()) {
						i8++;
						Integer value = map8.get(key);
						sheet.addCell(new jxl.write.Number(21, i8,  key));
						sheet.addCell(new jxl.write.Number(22, i8,  value));
					}
					for (Integer key : map9.keySet()) {
						i9++;
						Integer value = map9.get(key);
						sheet.addCell(new jxl.write.Number(24, i9,  key));
						sheet.addCell(new jxl.write.Number(25, i9,  value));
					}

					for (Integer key : tmap1.keySet()) {
						o1++;
						Integer value = tmap1.get(key);
						tSheet.addCell(new jxl.write.Number(0, o1,  key));
						tSheet.addCell(new jxl.write.Number(1, o1,  value));
					}
					for (Integer key : tmap2.keySet()) {
						o2++;
						Integer value = tmap2.get(key);
						tSheet.addCell(new jxl.write.Number(4, o2,  key));
						tSheet.addCell(new jxl.write.Number(5, o2,  value));
					}
					for (Integer key : tmap3.keySet()) {
						o3++;
						Double value = tmap3.get(key);
						tSheet.addCell(new jxl.write.Number(13, o3,  key));
						tSheet.addCell(new jxl.write.Number(14, o3,  value, wcfN));
					}
					for (Integer key : tmap4.keySet()) {
						o4++;
						Double value = tmap4.get(key);
						tSheet.addCell(new jxl.write.Number(17, o4,  key));
						tSheet.addCell(new jxl.write.Number(18, o4,  value, wcfN));
					}
					for (Integer key : tmap5.keySet()) {
						o5++;
						Double value = tmap5.get(key);
						tSheet.addCell(new jxl.write.Number(21, o5,  key));
						tSheet.addCell(new jxl.write.Number(22, o5,  value, wcfN));
					}
					for (Integer key : tmap6.keySet()) {
						o6++;
						Double value = tmap6.get(key);
						tSheet.addCell(new jxl.write.Number(29, o6,  key));
						tSheet.addCell(new jxl.write.Number(30, o6,  value, wcfN));
					}

					
					
					workbook.write();
					workbook.close();
					dt.setEnabled(false);
					jb.setEnabled(true);
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "响应率和填报率的基础数据" + mp.showdd() + ".xlsx(另一个程序正在使用此文件，请先关闭。)",
							"导出失败", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (WriteException e1) {
					e1.printStackTrace();
				}
			}
		});

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // 重写windowClosing(关闭窗体)这个方法
				System.exit(0); // 退出java虚拟机
			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public static void main(String[] args) {
		ss = new mainY(); // 构造方法
		//ss.repaint();
		
	}
	
	private void reload() {
		ss.repaint();
	}

	private void shezhi() {
		this.setSize(350, 150); // 设置窗体大小
		this.setTitle("填报率和响应率查询");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true); // 设置是否可调整大小

		this.setLayout(new BorderLayout());
		//this.repaint();
	}
}
