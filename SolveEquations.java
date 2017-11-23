package SmallKit;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ibm.icu.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SolveEquations extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private double a,b,c;
	private JTextField px2;
	private JTextField px;
	private JTextField pc;
	private JTextField textField_1;
	private JTextField textField_2;
//	public void getParameter()
//	{
//		Scanner scan = new Scanner(System.in);
//		System.out.println("输入!");
//		   a = scan.nextDouble();
//		   b = scan.nextDouble();
//		   c = scan.nextDouble();
//		scan.close();
//		System.out.println("输出!");
//		System.out.println(a+" "+b+" "+c);
//	}
	public void slove()
	{
		if(a!=0&&b!=0)
		{
			double delta=0;
			delta=b*b-4*a*c;
			if(delta==0)
			{
				double root=(-b)/(2*a);
				System.out.println("方程只有一个根为：");
				System.out.println(root);
			}
			else if(delta>0)
			{
				double root1=((-b)+Math.sqrt(delta))/(2*a);
				double root2=((-b)-Math.sqrt(delta))/(2*a);
				System.out.println("方程的两个根为：");
				System.out.println(root1+"和"+root2);
			}
			else
			{
				System.out.println("方程无实根，方程虚根为：");
				System.out.println((-b)/(2*a)+"+"+(Math.sqrt(-delta))/(2*a)+"i"+"和"+(-b)/(2*a)+"-"+(Math.sqrt(-delta))/(2*a)+"i");
			}
		}
			
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolveEquations frame = new SolveEquations();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
//					int ans=0;
//					for(int i=1;i<=6;i++)
//					{
//						ans+=i*11;
//					}
//					System.out.println(ans);
//
//				SolveEquations sq=new SolveEquations();
//					sq.getParameter();
//					sq.slove();
				//System.out.println("Hello World!");
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SolveEquations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblaxBx = new JLabel("\u8F93\u5165ax2+ bx + c = 0\u65B9\u7A0B\u7684\u7CFB\u6570a,b,c");
		lblaxBx.setBounds(10, 10, 219, 28);
		contentPane.add(lblaxBx);
		
		px2 = new JTextField();
		px2.setBounds(10, 60, 51, 21);
		contentPane.add(px2);
		px2.setColumns(10);
		
		JLabel lblX = new JLabel("x2   +");
		lblX.setBounds(69, 66, 56, 15);
		contentPane.add(lblX);
		
		px = new JTextField();
		px.setBounds(135, 60, 51, 21);
		contentPane.add(px);
		px.setColumns(10);
		
		JLabel label = new JLabel("x   +");
		label.setBounds(193, 66, 56, 15);
		contentPane.add(label);
		
		pc = new JTextField();
		pc.setBounds(242, 60, 51, 21);
		contentPane.add(pc);
		pc.setColumns(10);
		
		JLabel label_1 = new JLabel("=  0");
		label_1.setBounds(313, 66, 56, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7ED3\u679C\uFF1A");
		label_2.setBounds(10, 136, 54, 15);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(59, 171, 121, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblX_1 = new JLabel("x1 =");
		lblX_1.setBounds(10, 174, 29, 15);
		contentPane.add(lblX_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(303, 171, 121, 21);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("x2 =");
		label_3.setBounds(254, 174, 29, 15);
		contentPane.add(label_3);
		
		JButton button = new JButton("\u8BA1\u7B97");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					a = Double.parseDouble(px2.getText().toString());
					b = Double.parseDouble(px.getText().toString());
					c = Double.parseDouble(pc.getText().toString());

					DecimalFormat    df   = new DecimalFormat("######0.00");  
					
					if(a!=0&&b!=0)
					{
						double delta=0;
						delta=b*b-4*a*c;
						if(delta==0)
						{
							String root=df.format((-b)/(2*a));
							//System.out.println("方程只有一个根为：");
							textField_2.setText("空");
							textField_1.setText(root);
							//System.out.println(root);
						}
						else if(delta>0)
						{
							String root1=df.format(((-b)+Math.sqrt(delta))/(2*a));
							String root2=df.format(((-b)-Math.sqrt(delta))/(2*a));
							textField_1.setText(root1);
							textField_2.setText(root2);
//							System.out.println("方程的两个根为：");
//							System.out.println(root1+"和"+root2);
						}
						else
						{
							String r11,r12;
							r11=df.format((-b)/(2*a));
							r12=df.format((Math.sqrt(-delta))/(2*a));
							textField_1.setText(r11+"+"+r12+"i");
							textField_2.setText(r11+"-"+r12+"i");
							
//							System.out.println("方程无实根，方程虚根为：");
//							System.out.println((-b)/(2*a)+"+"+(Math.sqrt(-delta))/(2*a)+"i"+"和"+(-b)/(2*a)+"-"+(Math.sqrt(-delta))/(2*a)+"i");
						}
					}
					}catch(Exception e){
					JOptionPane.showConfirmDialog(null, "输入非法请重新写输入！", "提示", JOptionPane.YES_NO_OPTION); 
					}

				//System.out.println(a+" "+b+" "+c);

				
				
				
			}
		});
		button.setBounds(291, 109, 93, 23);
		contentPane.add(button);
		
	}
}
