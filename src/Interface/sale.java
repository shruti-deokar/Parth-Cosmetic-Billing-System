/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Interface;
import com.mysql.jdbc.Connection;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.geom.Area;

/**
 *
 * @author Admin
 */
public class sale extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddItem
     */
    
    
     PreparedStatement pst = null;
    ResultSet rs = null;
    Connection conn;
    
    
    //private ImageIcon format=null;
   // String fname=null;
    //int s=0;
    //byte[] pimage=null;
    String cname;
    String cmono;
    String iid;
    String iname;
    //String category;
    String uprice;
    String noitem;
    String tprice;
    String discount;
    String payble;
    String cash;
    String balance;
    String barcode;
    String date;
    //String date;
    
    
    
    
    public sale() {
        initComponents();
        UpdateQty();
        ShowDate();
        
        
       // tableLord();
        //saletableLord();
        //conn =  (Connection) DBConnection.connect();
       this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
       BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
       bi.setNorthPane(null);
       
    }
    
    public void bill(){
        
      //Area.setText(Area.getText()+"================================================================================================================\n");
        Area.setText(Area.getText()+"----------------------------------------------------------------------------------------------------------------\n");
        Area.setText(Area.getText()+"  \t\t PARTH COSMETIC  \n parthcosmetic0707@gmail.com" );
        Date obj = new Date();
        String date = obj.toString();
        
        Area.setText(Area.getText()+"\t"+date+"\n");
        //Area.setText(Area.getText()+"---------------------------------------------------------------------------------------------------------------\n");
        
        String Customer_Name = txtcname.getText();
        Area.setText(Area.getText()+"Customer Name :-  ");
        Area.setText(Area.getText()+Customer_Name+"\t");
        String Customer_MoNo = txtcmono.getText();
        Area.setText(Area.getText()+"Customer Mo.No :-  ");
        Area.setText(Area.getText()+Customer_MoNo+"\n");
        Area.setText(Area.getText()+"---------------------------------------------------------------------------------------------------------------\n");
        
                //String cnm ="SELECT `customer_name`FROM `customer` WHERE = ?";
        //String Customer_Name = txtcname.getText();
        //Area.setText(Area.getText()+"Customer_Name\n");
        //String Customer_Name = txtcname.getText();
            //Area.setText(Customer_Name);
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        Area.setText(Area.getText()+"Item Name"+"\t"+"Unit Price"+"\t"+"Quantity"+"\t"+"Discount"+"\n");
        for(int i=0;i<jTable1.getRowCount();i++){
            //String Customer_Name = jTable1.getValueAt(i,0).toString();
            String Item_Name = jTable1.getValueAt(i,1).toString();
            String Unit_Price = jTable1.getValueAt(i,2).toString();
            String Quantity = jTable1.getValueAt(i,3).toString();
            String Discount = jTable1.getValueAt(i,4).toString();
            //String Cash = jTable1.getValueAt(i,5).toString();
            //String Total_Price = TotalPrice.getText();
            //Area.setText(Area.getText()+"Cash"+"\t"+"Total Price");
            Area.setText(Area.getText()+Item_Name+"\t"+Unit_Price+"\t"+ Quantity+"\t"+Discount+"\t"+"\n");
            
           // String Cash = jTable1.getValueAt(i,5).toString();
            //String Total_Price = TotalPrice.getText();

            //Area.setText(Area.getText()+"Total Price");
             //Area.setText(Area.getText()+Total_Price+"\n");
        }
        Area.setText(Area.getText()+"---------------------------------------------------------------------------------------------------------------\n");
        String Total_Price = TotalPrice.getText();

            Area.setText(Area.getText()+"Total Price\t");
             Area.setText(Area.getText()+Total_Price+"\n");
            //String Total_Price = TotalPrice.getText();
            //Area.setText(Total_Price);
            //Area.setText(Area.getText()+"Total_Price\n");
            Area.setText(Area.getText()+"\n");
            Area.setText(Area.getText()+"---------------------------------------------------------------------------------------------------------------\n");
            //Area.setText(Area.getText()+"============================================================================================================\n");
            Area.setText(Area.getText()+"\t\t   Thanks For Visit!!!   \n");
            //Area.setText(Area.getText()+"=============================================\n");

            
        

        
    }
    
    
    private void UpdateQty(){
        
            try {
            //int newQty = AvailQty - Integer.valueOf(txtnoitem.getText());
            
            //String UpdateQuery ="Update stock set no_of_items=- where item_id=?";
           // String sql ="SELECT * FROM `sale` WHERE 1";
            //String sql = "SELECT no_of_items from stock,s,sale,sl where s.item_id = s1.item_id";
            //no_of_items = no_of_items-no_of_item;
             String sql = "update stock set no_of_items = no_of_items-Int.parseInt(txtnoitem.getText()) WHERE no_of_items=? ";      
            
          //  String UpdateQuery = "UPDATE `stock` SET `item_id`='[value-1]',`item_name`='[value-2]',`category`='[value-3]',`serial_no`='[value-4]',`buy_price`='[value-5]',`sale_price`='[value-6]',`no_of_items`='[value-7]',`barcode`='[value-8]',`mark`='[value-9]' WHERE 1"
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hardwaredb","root","");
            PreparedStatement pst =  DBConnection.connect().prepareStatement(sql);
            
           // ps.setString(0, "Name");
           
            //ps.setInt(1, newQty);
            //ps.setInt(2,key);
           // ps.setString(3,jTextField3.getText());
           //ps.setInt(3,1000);
           pst.executeUpdate();
           // if (ps.executeUpdate()==1) {
               
                //JOptionPane.showMessageDialog(this,"Items Updated");
                 //DisplayItems();
                //clear();
                
            //} 
        } catch (Exception e) {
            System.out.println(e);
        }
            
        }
    
    private void ShowDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        TodayDate.setText(s.format(d));
    }

       
    
   /* private void saletableLord()
   {
       
       try{
           
           String sql="SELECT * FROM `sale`";
           PreparedStatement pst =  DBConnection.connect().prepareStatement(sql);
           ResultSet rs=(ResultSet) pst.executeQuery();
           tblsale.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel((java.sql.ResultSet) rs));
           
       }catch(Exception e){
           
           System.out.println("Sale Table Show  Error : "+e);
           
       }
       
   }*/
    
    
    private void lordData()
    {
        
        //sid=lblsid.getText();
        iid=txtiid.getText();
        uprice=txtuprice.getText();
        noitem=txtnoitem.getText();
        tprice=txttprice.getText();
        discount=txtdiscount.getText();
        payble=txtpayble.getText();
        cash=txtcash.getText();
        balance=txtbalance.getText();
        date=TodayDate.getText();
        //LocalDate ndate = LocalDate.now();
        //date = ndate+"";
        
    }

   
    public void itemLord()
    {
         String name = txtiname.getText();
//         System.out.println("name : "+name);
        try{
          String sql="SELECT `item_id`,`item_name`,`sale_price` FROM `stock` WHERE item_name Like '%"+txtiname.getText()+"%'";
           PreparedStatement pst =  DBConnection.connect().prepareStatement(sql);
           rs = pst.executeQuery();
          while(rs.next())
          {
//   tblsale           System.out.println("id : "+rs.getInt("item_id"));
              txtiid.setText(String.valueOf(rs.getInt("item_id")));
              
//              System.out.println("name : "+rs.getString("item_name"));
//              txtiname.setText(rs.getString("item_name"));
              
//              System.out.println("price : "+rs.getString("sale_price"));
              txtuprice.setText(rs.getString("sale_price"));
              
//              System.out.println("Barcode : "+rs.getInt("barcode"));
              //txtbarcode.setText(String.valueOf(rs.getInt("barcode")));

          }
        }catch(Exception e){
//          JOptionPane.showMessageDialog(rootPane, e);  
            System.out.println("erorrororooro" +e);
        }
}

         
     
  
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label4 = new java.awt.Label();
        lbl = new java.awt.Label();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        txtiname = new javax.swing.JTextField();
        txtnoitem = new javax.swing.JTextField();
        txtiid = new javax.swing.JTextField();
        txtcname = new javax.swing.JTextField();
        txtdiscount = new javax.swing.JTextField();
        txttprice = new javax.swing.JTextField();
        label9 = new java.awt.Label();
        txtpayble = new javax.swing.JTextField();
        txtcash = new javax.swing.JTextField();
        label10 = new java.awt.Label();
        label11 = new java.awt.Label();
        txtbalance = new javax.swing.JTextField();
        txtuprice = new javax.swing.JTextField();
        addtocart = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl1 = new java.awt.Label();
        txtcmono = new javax.swing.JTextField();
        TodayDate = new javax.swing.JTextField();
        label12 = new java.awt.Label();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TotalPrice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Area = new javax.swing.JTextArea();
        btnbill = new javax.swing.JButton();
        btnprint1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(936, 530));

        jPanel1.setBackground(new java.awt.Color(153, 0, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(719, 524));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 670, -1));

        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label1.setMinimumSize(new java.awt.Dimension(58, 21));
        label1.setText(" No of Item");

        label2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label2.setText("Item Id");

        label4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label4.setText("Item Name");

        lbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl.setPreferredSize(new java.awt.Dimension(58, 21));
        lbl.setText("Customer mono");

        label6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label6.setPreferredSize(new java.awt.Dimension(58, 21));
        label6.setText("Total Price");

        label7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label7.setName(""); // NOI18N
        label7.setPreferredSize(new java.awt.Dimension(58, 21));
        label7.setText("Unit of Price");

        label8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label8.setText("Discount");

        txtiname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtiname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtinameActionPerformed(evt);
            }
        });
        txtiname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtinameKeyReleased(evt);
            }
        });

        txtnoitem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnoitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoitemActionPerformed(evt);
            }
        });
        txtnoitem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnoitemKeyReleased(evt);
            }
        });

        txtiid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtiid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtiidActionPerformed(evt);
            }
        });
        txtiid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtiidKeyReleased(evt);
            }
        });

        txtcname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcnameActionPerformed(evt);
            }
        });

        txtdiscount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtdiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiscountActionPerformed(evt);
            }
        });
        txtdiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscountKeyReleased(evt);
            }
        });

        txttprice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttpriceActionPerformed(evt);
            }
        });

        label9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label9.setText("Payble");

        txtpayble.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpayble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpaybleActionPerformed(evt);
            }
        });

        txtcash.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcashKeyReleased(evt);
            }
        });

        label10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label10.setText("Cash");

        label11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label11.setText("Balance");

        txtbalance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtbalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbalanceActionPerformed(evt);
            }
        });

        txtuprice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtuprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtupriceActionPerformed(evt);
            }
        });

        addtocart.setBackground(new java.awt.Color(0, 153, 153));
        addtocart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addtocartMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add to Cart");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jLabel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel5KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout addtocartLayout = new javax.swing.GroupLayout(addtocart);
        addtocart.setLayout(addtocartLayout);
        addtocartLayout.setHorizontalGroup(
            addtocartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addtocartLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        addtocartLayout.setVerticalGroup(
            addtocartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addtocartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Clear");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl1.setPreferredSize(new java.awt.Dimension(58, 21));
        lbl1.setText("Customer Name");

        txtcmono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcmono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcmonoActionPerformed(evt);
            }
        });
        txtcmono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcmonoKeyReleased(evt);
            }
        });

        TodayDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TodayDate.setText("Date");
        TodayDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TodayDateActionPerformed(evt);
            }
        });

        label12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label12.setText("Date");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(label4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnoitem)
                                    .addComponent(txtiname, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(txtiid, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(txtcname, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(txtuprice, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(txtcmono, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                                .addContainerGap(7, Short.MAX_VALUE))
                            .addComponent(txttprice)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label8, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(label12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtpayble, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtcash, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtbalance, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TodayDate)
                                    .addComponent(txtdiscount)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(addtocart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtcname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcmono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtuprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnoitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpayble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(TodayDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addtocart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 440, 500));

        jPanel4.setPreferredSize(new java.awt.Dimension(380, 520));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Item Name", "Unit of Price", "Quantity", "Disconut", "Cash", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        TotalPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalPriceActionPerformed(evt);
            }
        });

        jButton1.setText("Total Price:-");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Area.setColumns(20);
        Area.setRows(5);
        jScrollPane1.setViewportView(Area);

        btnbill.setText("Bill");
        btnbill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbillActionPerformed(evt);
            }
        });

        btnprint1.setText("Print");
        btnprint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprint1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnprint1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnbill)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(TotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnprint1))
                    .addComponent(btnbill, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 430, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnoitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoitemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnoitemActionPerformed

    private void txtcnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcnameActionPerformed

    private void txtupriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtupriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtupriceActionPerformed

    private void txtiidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtiidKeyReleased
      
//       if(txtid.getText()) 
//       {
//         itemLord();  
//       }
       itemLord(); 

        
        
    }//GEN-LAST:event_txtiidKeyReleased

    private void txtnoitemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnoitemKeyReleased
        
        double price = Double.parseDouble(txtuprice.getText());
        double unit = Double.parseDouble(txtnoitem.getText());
        double tprice = price*unit;
        txttprice.setText(tprice+"");
        
    }//GEN-LAST:event_txtnoitemKeyReleased

    private void txttpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttpriceActionPerformed
        
       // double discount = Double.parseDouble(txtdiscount.getText());
        // double tprice = Double.parseDouble(txttprice.getText());
        // double payble = tprice-discount;
        // txtpayble.setText(payble+"");
    }//GEN-LAST:event_txttpriceActionPerformed

    private void txtdiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscountKeyReleased
        
         double discount = Double.parseDouble(txtdiscount.getText());
         double tprice = Double.parseDouble(txttprice.getText());
         //double payble = tprice-discount;
         double payble = tprice-(tprice*discount/100);
         txtpayble.setText(payble+"");
    }//GEN-LAST:event_txtdiscountKeyReleased

    private void txtcashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcashKeyReleased
        
        
     double cash = Double.parseDouble(txtcash.getText());
     double payble = Double.parseDouble(txtpayble.getText());
     double balance = cash-payble; 
     txtbalance.setText(balance+"");
    }//GEN-LAST:event_txtcashKeyReleased

    //int GrdTotal = 0;
    //int AvailQty = 0;
    private void addtocartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addtocartMouseClicked

            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.addRow(new Object[]{txtcname.getText(),txtiname.getText(),txtuprice.getText(),txtnoitem.getText(),txtdiscount.getText(),txtcash.getText(),TodayDate.getText()});

           DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
            //if(jTable1.getRowCount() != 0){
                //for(int i=0;i<jTable1.getRowCount();i++){
                    //try{
                        //PreparedStatement pst =  DBConnection.connect().prepareStatement();
                      //  Statement st = DBConnection.connect().createStatement();
                       // st.executeUpdate("update stock set no_of_item=no_of_item-"+txtnoitem.getText()+ " where item_id ="+txtiid.getText());
                    //}
                    //catch(Exception e){
                     //   JOptionPane.showMessageDialog(null, e);
                    //}
               // }
           // }
        
        getdata();
       try{
           
           
            //String q="INSERT INTO `sale`(`customer_name`, `customer_mono`, `item_id`, `item_name`, `unit_price`, `no_of_item`, `total_price`, `discount`, `payable`, `cash`, `balance`, `date`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            String q="INSERT INTO `sale`(`customer_name`, `customer_mono`, `item_id`, `item_name`, `unit_price`, `no_of_item`, `total_price`, `discount`, `payable`, `cash`, `balance`, `date`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
             PreparedStatement pst =  DBConnection.connect().prepareStatement(q);
             

             //pst.setString(1, sid);
             pst.setString(1,cname );
             pst.setString(2, cmono);
             pst.setString(3,iid);
              pst.setString(4,iname);
              pst.setString(5,uprice);
              pst.setString(6,noitem);
              pst.setString(7,tprice);
              pst.setString(8,discount);
              pst.setString(9,payble);
              pst.setString(10,cash);
              pst.setString(11,balance);
              pst.setString(12,date);
             
             
              pst.executeUpdate();
              JOptionPane.showMessageDialog(null, "Sale Product Added");
              //clearData();
              //tableLord();
              
        }catch (Exception e){
            System.out.println("sale product "+e);
        }


             
       
       // makebill();
        
       // lordData();
      // try{
          
           /** int barco = Integer.parseInt(txtbarcode.getText());
            String q= "INSERT INTO `sale`(`sale_id`, `item_id`, `unit_price`, `no_of_item`, `total_price`, `discount`, `payable`, `cash`, `balance`, `date`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            //String q= "INSERT INTO `stock`( `item_name`, `category`, `serial_no`, `buy_price`, `sale_price`, `no_of_items`, `barcode`, `mark`) VALUES (?,?,?,?,?,?,?,?)";
            
             PreparedStatement pst =  DBConnection.connect().prepareStatement(q);
             
              pst.setString(1, sid);
              pst.setString(2,iname);
              pst.setString(3,uprice);
              pst.setString(4,noitem);
              pst.setString(5,tprice);
              pst.setString(6,discount);
              pst.setString(7,payble);
              pst.setString(8,cash);
              pst.setString(9,balance);
              pst.setString(10, date);
              //pst.setString(8, "1");
              pst.execute();
              
              
        }catch (Exception e){
            
        }*/
       
       /*getdata();
       try{
           
           
            String q="INSERT INTO `sale`(`customer_name`, `customer_mono`, `item_id`, `item_name`, `unit_price`, `no_of_item`, `total_price`, `discount`, `payable`, `cash`, `balance`, `barcode`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            
             PreparedStatement pst =  DBConnection.connect().prepareStatement(q);
             

             //pst.setString(1, sid);
             pst.setString(1,cname );
             pst.setString(2, cmono);
             pst.setString(3,iid);
              pst.setString(4,iname);
              pst.setString(5,uprice);
              pst.setString(6,noitem);
              pst.setString(7,tprice);
              pst.setString(8,discount);
              pst.setString(9,payble);
              pst.setString(10,cash);
              pst.setString(11,balance);
              pst.setString(12,barcode);
             
             
              pst.executeUpdate();
              JOptionPane.showMessageDialog(null, "Sale Product Added");
              //clearData();
              //tableLord();
              JOptionPane.showMessageDialog(null, "sale product");
        }catch (Exception e){
            System.out.println("sale product "+e);
        }
          */
        
    }//GEN-LAST:event_addtocartMouseClicked

    private void txtinameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtinameKeyReleased
        // TODO add your handling code here:
//        if(txtiname.getText().length()==1) 
//       {
         itemLord();  
       
    }//GEN-LAST:event_txtinameKeyReleased

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        
         txtiid.setText("");
       txtiname.setText("");
        //cmbcategory.setText("");
       //txtserialno.setText("");
        txtuprice.setText("");
        //txtsprice.setText("");
        txtnoitem.setText("");
        txttprice.setText("");
        txtdiscount.setText("");
        txtpayble.setText("");
        txtcash.setText("");
        txtbalance.setText("");
        //TodayDate.setText("");
         JOptionPane.showMessageDialog(null, "field clear");
        
    }//GEN-LAST:event_jPanel8MouseClicked

     /*private void tableLord()
   {
       
       try{
           
        
        String sql ="SELECT `sale_id`, `item_id`, `unit_price`, `no_of_item`, `total_price`, `discount`, `payable`, `cash`, `balance`, `date` FROM `sale` ";
           PreparedStatement pst =  DBConnection.connect().prepareStatement(sql);
           ResultSet rs=(ResultSet) pst.executeQuery();
           //tblsale.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel((java.sql.ResultSet) rs));
           
       }catch(Exception e){
           
           System.out.println("Sale table Errororo "+e );
           
       }
       
   }*/
    
    private void getdata()
    {
        
       cname=txtcname.getText();
       cmono=txtcmono.getText();
       iid = txtiid.getText();
       iname = txtiname.getText();
       uprice = txtuprice.getText();
       noitem = txtnoitem.getText();
       tprice = txttprice.getText();
       discount = txtdiscount.getText();
       payble = txtpayble.getText();
       cash = txtcash.getText();
       balance = txtbalance.getText();
       date = TodayDate.getText();
      // date = txtdate.getText();
      
     
    }
    
    private void txtinameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtinameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtinameActionPerformed

    private void jLabel5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel5KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel5KeyPressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txtpaybleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpaybleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaybleActionPerformed

    private void txtdiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiscountActionPerformed

    private void txtcmonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcmonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcmonoActionPerformed

    private void txtiidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtiidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtiidActionPerformed

    private void txtbalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbalanceActionPerformed

    private void txtcmonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcmonoKeyReleased
        // TODO add your handling code here:
        String mobile = txtcmono.getText();
//         System.out.println("name : "+mobile);
        try{
          String sql="SELECT `customer_name` FROM `customer`  WHERE `customer_mono` Like '%"+txtcmono.getText()+"%'";
           PreparedStatement pst =  DBConnection.connect().prepareStatement(sql);
           rs = pst.executeQuery();
          while(rs.next())
          {              
//              System.out.println("Customer Name : "+rs.getString("customer_name"));
              txtcname.setText(rs.getString("customer_name"));
          }
        }catch(Exception e){
//          JOptionPane.showMessageDialog(rootPane, e);  
            System.out.println("Customer Name Search Erorr : " +e);
        }
        
    }//GEN-LAST:event_txtcmonoKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
       // int index  = cartTable.getSelectedRow();
        //int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this Medicine","select",JOptionPane.YES_NO_OPTION);
       // if(a==0){
            //TableModel model =cartTable.getModel();
            //String total = model.getValueAt(index, 5).toString();
            //finalcash = finalcash - Integer.parseInt(total);
            //lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            //((DefaultTableModel) cartTable.getModel()).removeRow(index);
       // }
    }//GEN-LAST:event_jTable1MouseClicked

    private void TodayDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TodayDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TodayDateActionPerformed

    private void TotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalPriceActionPerformed
        // TODO add your handling code here:
        
        
       /* try{
            String sql = "Select count(cash) from sale";
            PreparedStatement pst =  DBConnection.connect().prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                String sum = rs.getString("count(cash)");
                TotalPrice.setText(sum);
                
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }*/
        
    }//GEN-LAST:event_TotalPriceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int numrow = jTable1.getRowCount();
        
        double tot = 0;
        
        for(int i = 0; i < numrow; i++){
            double val = Double.valueOf(jTable1.getValueAt(i, 5).toString());
            
            tot += val;
        }
        
        TotalPrice.setText(Double.toString(tot));
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnprint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprint1ActionPerformed
        // TODO add your handling code here:
        try{
            
            Area.print();
            
        }catch (Exception e){
            
        }
    }//GEN-LAST:event_btnprint1ActionPerformed

    private void btnbillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbillActionPerformed
        // TODO add your handling code here:
        
        bill();
        
        
    }//GEN-LAST:event_btnbillActionPerformed

   /*private void makebill()
    {
         
                        
       // txtbill.setText(txtbill.getText()+ "Item Name\t"+jTable1.getValueAt(i, 0).toString();+"\tNO of item\t"+txtnoitem.getText()+"\tUnit Price\t"+txtuprice.getText()
        //+"\tTotal Price\t"+txttprice.getText()+"\tDiscount\t"+txtdiscount.getText()+"\tPayble\t"+txtpayble.getText()+"\tCash\t"+txtcash.getText()+"\nBalance\t"+txtbalance.getText()+"\n\nThanks For Visit!!!\n");
    }  
    
    private void billheader()
    {
        
       Area.setText("Cosmetic store \nparthcosmetic0707@gmail.com\n\n");
        
    }*/
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Area;
    private javax.swing.JTextField TodayDate;
    private javax.swing.JTextField TotalPrice;
    private javax.swing.JPanel addtocart;
    private javax.swing.JButton btnbill;
    private javax.swing.JButton btnprint1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label2;
    private java.awt.Label label4;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.Label lbl;
    private java.awt.Label lbl1;
    private javax.swing.JTextField txtbalance;
    private javax.swing.JTextField txtcash;
    private javax.swing.JTextField txtcmono;
    private javax.swing.JTextField txtcname;
    private javax.swing.JTextField txtdiscount;
    private javax.swing.JTextField txtiid;
    private javax.swing.JTextField txtiname;
    private javax.swing.JTextField txtnoitem;
    private javax.swing.JTextField txtpayble;
    private javax.swing.JTextField txttprice;
    private javax.swing.JTextField txtuprice;
    // End of variables declaration//GEN-END:variables

}
