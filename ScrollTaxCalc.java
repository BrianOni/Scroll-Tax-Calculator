import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.text.DecimalFormat;

 
public class ScrollTaxCalc extends JFrame

{

    private final JLabel label1;
    private final JLabel label2;          //Message labels
    private final JLabel label3;          //Message labels
    private final JTextField purchaseAmount;              //Amount of purchase
    private final JTextField salesTax;                        //Sales tax
    private final JPanel ppanel;                              //Amount of purchase panel
    private final JPanel spanel;                              //Sales tax panel
    private final JPanel tsliderpanel;                        //Tax rate Slider panel
    private final JSlider slider;                             //Tax rate slider
    
  
    public ScrollTaxCalc()

    {

        setTitle("Sales Tax Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel("Amount of purchase: ");
        label2 = new JLabel("Tax Rate(%)");
        label3 = new JLabel("Sales Tax: ");

        purchaseAmount = new JTextField(10);
        
	salesTax = new JTextField(10);
        salesTax.setEditable(false);
        salesTax.setText("0.00");      


        slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        slider.setMajorTickSpacing(5);      //Major tick every 5.
        slider.setMinorTickSpacing(1);      //Minor tick every 1.
        slider.setPaintTicks(true);     //Display the tick marks
        slider.setPaintLabels(true);            //Display numbers
        slider.addChangeListener(new SliderListener());

        ppanel = new JPanel();
        ppanel.add(label1);
        ppanel.add(purchaseAmount);
        tsliderpanel = new JPanel();
        tsliderpanel.add(label2);
        tsliderpanel.add(slider);
        spanel = new JPanel();
        spanel.add(label3);
        spanel.add(salesTax);

       
        setLayout(new GridLayout(3, 1));

         
        add(ppanel);
        add(tsliderpanel);
        add(spanel);

        pack();
        setVisible(true);

    }

    

    private class SliderListener implements ChangeListener

    {

        public void stateChanged(ChangeEvent e)

        {
             
            double tax, sales;

            DecimalFormat form = new DecimalFormat("#,##0.00");

            //Get the slider value.

            tax = slider.getValue() / 100.00;
            
            //Calculate sales tax.

            sales = Double.parseDouble(purchaseAmount.getText()) * tax;
            
            //Store the sales tax in its display field.

            salesTax.setText(form.format(sales));

        }

    }
    
    public static void main(String[] args)

    {

        new ScrollTaxCalc();

    }

}

            
