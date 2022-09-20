/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

/**
 *
 * @author GUILLERMO
 */
public class Resultadox3 extends javax.swing.JFrame {

    /**
     * Creates new form Resultadox3
     */
    public Resultadox3() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public Resultadox3(String dx3, String dx2, String dx1, String dx0) {
        initComponents();
        x3.setText(dx3);
        x2.setText(dx2);
        x1.setText(dx1);
        x0.setText(dx0);
    }
    
    int paso=1;
    
    float Vd1_x0, Vd1_x1, Vd1_x2, Vd1_x3,
            Vds1_x0, Vds1_x1, Vds1_x2,
            Vd2_x0, Vd2_x1, Vd2_x2, Vd2_x3,
            Vds2_x1, Vds2_x2,
            Vr_x3, Vr_x2, Vr_x1;
    
    float xActual;
    float nuevaR;
    
    public void procedimiento() {
        switch(paso) {
            case 1:
                getDivInicial_3();
                instruccionText.setText("Se encuentra el primer valor de X, siendo el negativo del último valor dividido entre el penúltimo.");
                nuevaX();
                paso ++;
            break;
            case 2:
                birgeVieta_3();
            break;
            case 3:
                instruccionText.setText("Se simplifica la expresión con la raíz encontrada, si hay residuo, se hace a un lado.");
                divPoly_3();
                paso++;
            break;
            case 4:
                allToBlank();
                getDivInicial_2();
                instruccionText.setText("Se encuentra el primer valor de X, siendo el negativo del último valor dividido entre el penúltimo.");
                nuevaX();
                paso++;
            break;
            case 5:
                birgeVieta_2();
            break;
            case 6:
                instruccionText.setText("Se simplifica la expresión con la raíz encontrada, si hay residuo, se hace a un lado.");
                divPoly_2();
                paso++;
            break;
            case 7:
                instruccionText.setText("La ecuación restante delata la última raíz, acabando el procedimiento.");
                float ultimaRaiz = Float.parseFloat(x0.getText());
                ultimaRaiz = ultimaRaiz * (-1);
                raiz3.setText(Float.toString(ultimaRaiz));
                paso++;
            break;
        }
    }
    
    public void nuevaX() {
             
        xActual = ((Vd1_x0) * -1) / Vd1_x1;
        actualX.setText(Float.toString(xActual));
    }
    
    public void siguienteX() {
        //
        tf_xActual.setText(Float.toString(xActual));
        tf_PdeX.setText(Float.toString(Vd2_x0));
        tf_PAdeX.setText(Float.toString(Vr_x1));
        xActual = (xActual) - ((Vd2_x0) / (Vr_x1));
        
        tf_xNueva.setText(Float.toString(xActual));
        actualX.setText(Float.toString(xActual));
    }
    
    public void allToBlank() {
        ds1_x2.setText("-");
        ds1_x1.setText("-");
        ds1_x0.setText("-");
        
        d2_x3.setText("-");
        d2_x2.setText("-");
        d2_x1.setText("-");
        d2_x0.setText("-");
        
        ds2_x2.setText("-");
        ds2_x1.setText("-");
        
        r_x3.setText("-");
        r_x2.setText("-");
        r_x1.setText("-");
    }
    
    public void setNewXBlank() {
        tf_xActual.setText("-");
        tf_PdeX.setText("-");
        tf_PAdeX.setText("-");
        tf_xNueva.setText("-");
    }
    
    public void birgeVieta_3() {
        allToBlank();
        
        Vd2_x3 = Vd1_x3;
        d2_x3.setText(Float.toString(Vd2_x3));
        
        Vds1_x2 = ((xActual) * (Vd2_x3));
        ds1_x2.setText(Float.toString(Vds1_x2));
        
        Vd2_x2 = (Vd1_x2) + (Vds1_x2);
        d2_x2.setText(Float.toString(Vd2_x2));
        
        Vds1_x1 = ((xActual) * (Vd2_x2));
        ds1_x1.setText(Float.toString(Vds1_x1));
        
        Vd2_x1 = (Vd1_x1) + (Vds1_x1);
        d2_x1.setText(Float.toString(Vd2_x1));
        
        Vds1_x0 = ((xActual) * (Vd2_x1));
        ds1_x0.setText(Float.toString(Vds1_x0));
        
        Vd2_x0 = (Vd1_x0) + (Vds1_x0);
        d2_x0.setText(Float.toString(Vd2_x0));
        
        if(Vd2_x0 < 0.1) {
            instruccionText.setText("Se encontró un valor de x aproximado a la raíz de la ecuación.");
            
            nuevaR = Math.round(xActual);
            raiz1.setText(Float.toString(nuevaR));
            paso++;
        } else {
            Vr_x3 = Vd2_x3;
            r_x3.setText(Float.toString(Vr_x3));
            
            Vds2_x2 = ((xActual) * (Vr_x3));
            ds2_x2.setText(Float.toString(Vds2_x2));
            
            Vr_x2 = (Vd2_x2) + (Vds2_x2);
            r_x2.setText(Float.toString(Vr_x2));
            
            Vds2_x1 = ((xActual) * (Vr_x2));
            ds2_x1.setText(Float.toString(Vds2_x1));
            
            Vr_x1 = (Vd2_x1) + (Vds2_x1);
            r_x1.setText(Float.toString(Vr_x1));
            
            instruccionText.setText("P no se acerca a 0, por lo tanto se busca un nuevo valor de x.");
            
            siguienteX();
        }
    }
    
    public void birgeVieta_2() {
        allToBlank();
        
        Vd2_x2 = Vd1_x2;
        d2_x2.setText(Float.toString(Vd2_x2));
        
        Vds1_x1 = ((xActual) * (Vd2_x2));
        ds1_x1.setText(Float.toString(Vds1_x1));
        
        Vd2_x1 = (Vd1_x1) + (Vds1_x1);
        d2_x1.setText(Float.toString(Vd2_x1));
        
        Vds1_x0 = ((xActual) * (Vd2_x1));
        ds1_x0.setText(Float.toString(Vds1_x0));
        
        Vd2_x0 = (Vd1_x0) + (Vds1_x0);
        d2_x0.setText(Float.toString(Vd2_x0));
        
        if(Vd2_x0 < 0.1) {
            instruccionText.setText("Se encontró un valor de x aproximado a la raíz de la ecuación.");
            
            nuevaR = Math.round(xActual);
            raiz2.setText(Float.toString(nuevaR));
            paso++;
        } else {
            Vr_x2 = Vd2_x2;
            r_x2.setText(Float.toString(Vr_x2));
            
            Vds2_x1 = ((xActual) * (Vr_x2));
            ds2_x2.setText(Float.toString(Vds2_x2));
            
            Vr_x1 = (Vd2_x1) + (Vds2_x1);
            r_x1.setText(Float.toString(Vr_x1));
            
            instruccionText.setText("P no se acerca a 0, por lo tanto se busca un nuevo valor de x.");
            
            siguienteX();
        }
    }
    
    public void getDivInicial_2() {
        d1_x3.setText("-");
        Vd1_x2 = Float.parseFloat(x2.getText());
        Vd1_x1 = Float.parseFloat(x1.getText());
        Vd1_x0 = Float.parseFloat(x0.getText());
        
        d1_x2.setText(Float.toString(Vd1_x2));
        d1_x1.setText(Float.toString(Vd1_x1));
        d1_x0.setText(Float.toString(Vd1_x0));
    }
    
    public void getDivInicial_3() {
        Vd1_x3 = Float.parseFloat(x3.getText());
        Vd1_x2 = Float.parseFloat(x2.getText());
        Vd1_x1 = Float.parseFloat(x1.getText());
        Vd1_x0 = Float.parseFloat(x0.getText());
        
        d1_x3.setText(Float.toString(Vd1_x3));
        d1_x2.setText(Float.toString(Vd1_x2));
        d1_x1.setText(Float.toString(Vd1_x1));
        d1_x0.setText(Float.toString(Vd1_x0));
    }
    
    public void divPoly_2() {
        float px2, px1, px0, raizDivisora, restando, multiplo,
                nx1, nx0, residuo;
        px2 = Float.parseFloat(x2.getText());
        px1 = Float.parseFloat(x1.getText());
        px0 = Float.parseFloat(x0.getText());
        raizDivisora = nuevaR * (-1);
        
        multiplo = px2;
        nx1 = multiplo;
        restando = raizDivisora * multiplo;
        px1 = px1 - restando;
        
        multiplo = px1;
        nx0 = multiplo;
        restando = raizDivisora * multiplo;
        px0 = px0 - restando;
        
        residuo = px0;
        
        t2.setText("");
        x2.setText("");
        x1.setText(Float.toString(nx1));
        x0.setText(Float.toString(nx0));
        
        raizDivisora = raizDivisora * (-1);
        residuo2.setText(Float.toString(residuo));
        fraccionRaiz2.setText("x - (" + Float.toString(raizDivisora) + ")");
    }
    
    public void divPoly_3() {
        float px3, px2, px1, px0, raizDivisora, restando, multiplo,
                nx2 = 0, nx1 = 0, nx0 = 0, residuo;
        px3 = Float.parseFloat(x3.getText());
        px2 = Float.parseFloat(x2.getText());
        px1 = Float.parseFloat(x1.getText());
        px0 = Float.parseFloat(x0.getText());
        raizDivisora = nuevaR * (-1);
        
        multiplo = px3;
        nx2 = multiplo;
        restando = raizDivisora * multiplo;
        px2 = px2 - restando;
        
        multiplo = px2;
        nx1 = multiplo;
        restando = raizDivisora * multiplo;
        px1 = px1 - restando;
        
        multiplo = px1;
        nx0 = multiplo;
        restando = raizDivisora * multiplo;
        px0 = px0 - restando;
        
        residuo = px0;
        
        t3.setText("");
        x3.setText("");
        x2.setText(Float.toString(nx2));
        x1.setText(Float.toString(nx1));
        x0.setText(Float.toString(nx0));
        
        raizDivisora = raizDivisora * (-1);
        residuo1.setText(Float.toString(residuo));
        fraccionRaiz1.setText("x - (" + Float.toString(raizDivisora) + ")");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instruccionText = new javax.swing.JTextField();
        SigPaso = new javax.swing.JButton();
        OmiPaso = new javax.swing.JButton();
        regresarButton = new javax.swing.JButton();
        x3 = new javax.swing.JLabel();
        t3 = new javax.swing.JLabel();
        t2 = new javax.swing.JLabel();
        x2 = new javax.swing.JLabel();
        t1 = new javax.swing.JLabel();
        x1 = new javax.swing.JLabel();
        t6 = new javax.swing.JLabel();
        x0 = new javax.swing.JLabel();
        d1_x3 = new javax.swing.JTextField();
        d1_x2 = new javax.swing.JTextField();
        d1_x0 = new javax.swing.JTextField();
        d1_x1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ds1_x2 = new javax.swing.JTextField();
        ds1_x1 = new javax.swing.JTextField();
        ds1_x0 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        actualX = new javax.swing.JTextField();
        d2_x3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ds2_x2 = new javax.swing.JTextField();
        d2_x2 = new javax.swing.JTextField();
        d2_x1 = new javax.swing.JTextField();
        ds2_x1 = new javax.swing.JTextField();
        d2_x0 = new javax.swing.JTextField();
        r_x3 = new javax.swing.JTextField();
        r_x2 = new javax.swing.JTextField();
        r_x1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_PdeX = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf_xActual = new javax.swing.JTextField();
        tf_PAdeX = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_xNueva = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        raiz1 = new javax.swing.JTextField();
        raiz2 = new javax.swing.JTextField();
        raiz3 = new javax.swing.JTextField();
        fraccionRaiz1 = new javax.swing.JLabel();
        fraccionRaiz2 = new javax.swing.JLabel();
        fraccionRaiz3 = new javax.swing.JLabel();
        residuo1 = new javax.swing.JTextField();
        residuo2 = new javax.swing.JTextField();
        residuo3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        instruccionText.setText("Se empieza el procedimiento.");

        SigPaso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SigPaso.setText("Siguiente Paso");
        SigPaso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SigPasoMouseClicked(evt);
            }
        });

        OmiPaso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        OmiPaso.setText("Omitir Pasos");
        OmiPaso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OmiPasoMouseClicked(evt);
            }
        });

        regresarButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        regresarButton.setText("Regresar");
        regresarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarButtonMouseClicked(evt);
            }
        });

        x3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        x3.setText("1");

        t3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        t3.setText("x³");

        t2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        t2.setText("x²");

        x2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        x2.setText("0");

        t1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        t1.setText("x");

        x1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        x1.setText("0");

        t6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        x0.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        x0.setText("0");

        d1_x3.setEditable(false);
        d1_x3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        d1_x3.setText("-");
        d1_x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d1_x3ActionPerformed(evt);
            }
        });

        d1_x2.setEditable(false);
        d1_x2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        d1_x2.setText("-");
        d1_x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d1_x2ActionPerformed(evt);
            }
        });

        d1_x0.setEditable(false);
        d1_x0.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        d1_x0.setText("-");
        d1_x0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d1_x0ActionPerformed(evt);
            }
        });

        d1_x1.setEditable(false);
        d1_x1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        d1_x1.setText("-");
        d1_x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d1_x1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("-----------------------------------");

        ds1_x2.setEditable(false);
        ds1_x2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ds1_x2.setText("-");
        ds1_x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ds1_x2ActionPerformed(evt);
            }
        });

        ds1_x1.setEditable(false);
        ds1_x1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ds1_x1.setText("-");
        ds1_x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ds1_x1ActionPerformed(evt);
            }
        });

        ds1_x0.setEditable(false);
        ds1_x0.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ds1_x0.setText("-");
        ds1_x0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ds1_x0ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("+");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("x =");

        actualX.setEditable(false);
        actualX.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        d2_x3.setEditable(false);
        d2_x3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        d2_x3.setText("-");
        d2_x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d2_x3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("-----------------------------------");

        ds2_x2.setEditable(false);
        ds2_x2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ds2_x2.setText("-");
        ds2_x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ds2_x2ActionPerformed(evt);
            }
        });

        d2_x2.setEditable(false);
        d2_x2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        d2_x2.setText("-");
        d2_x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d2_x2ActionPerformed(evt);
            }
        });

        d2_x1.setEditable(false);
        d2_x1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        d2_x1.setText("-");
        d2_x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d2_x1ActionPerformed(evt);
            }
        });

        ds2_x1.setEditable(false);
        ds2_x1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ds2_x1.setText("-");
        ds2_x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ds2_x1ActionPerformed(evt);
            }
        });

        d2_x0.setEditable(false);
        d2_x0.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        d2_x0.setText("-");
        d2_x0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d2_x0ActionPerformed(evt);
            }
        });

        r_x3.setEditable(false);
        r_x3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        r_x3.setText("-");
        r_x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_x3ActionPerformed(evt);
            }
        });

        r_x2.setEditable(false);
        r_x2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        r_x2.setText("-");
        r_x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_x2ActionPerformed(evt);
            }
        });

        r_x1.setEditable(false);
        r_x1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        r_x1.setText("-");
        r_x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_x1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("P");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("P'");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Ecuación Actual");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("x =");

        tf_PdeX.setEditable(false);
        tf_PdeX.setText("-");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("-");

        tf_xActual.setEditable(false);
        tf_xActual.setText("-");

        tf_PAdeX.setEditable(false);
        tf_PAdeX.setText("-");

        jLabel10.setText("------------------");

        jLabel11.setText("=");

        tf_xNueva.setEditable(false);
        tf_xNueva.setText("-");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("Residuos");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Raíces");

        raiz1.setEditable(false);
        raiz1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        raiz1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        raiz1.setText("-");

        raiz2.setEditable(false);
        raiz2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        raiz2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        raiz2.setText("-");
        raiz2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raiz2ActionPerformed(evt);
            }
        });

        raiz3.setEditable(false);
        raiz3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        raiz3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        raiz3.setText("-");
        raiz3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raiz3ActionPerformed(evt);
            }
        });

        fraccionRaiz1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fraccionRaiz1.setText("-");

        fraccionRaiz2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fraccionRaiz2.setText("-");

        fraccionRaiz3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fraccionRaiz3.setText("-");

        residuo1.setEditable(false);
        residuo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        residuo2.setEditable(false);
        residuo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        residuo3.setEditable(false);
        residuo3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(x3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t3)
                        .addGap(18, 18, 18)
                        .addComponent(x2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t2)
                        .addGap(18, 18, 18)
                        .addComponent(x1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t1)))
                .addGap(18, 18, 18)
                .addComponent(x0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(SigPaso, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(OmiPaso, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regresarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(41, 41, 41))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(actualX, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ds1_x2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(ds1_x1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(ds1_x0, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(d1_x3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(d1_x2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(d1_x1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(d1_x0, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(r_x3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(r_x2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(r_x1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ds2_x2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ds2_x1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(84, 84, 84))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(d2_x3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(d2_x2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(d2_x1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(d2_x0, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(jLabel5)))
                        .addGap(62, 62, 62)))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(fraccionRaiz1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fraccionRaiz2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fraccionRaiz3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_PdeX, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_PAdeX, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(tf_xActual, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_xNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(raiz1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(raiz2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(raiz3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(748, 748, 748))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(instruccionText, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(residuo1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(residuo2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(residuo3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(773, 773, 773))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jLabel13)
                    .addContainerGap(927, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x3)
                    .addComponent(t3)
                    .addComponent(x2)
                    .addComponent(t2)
                    .addComponent(x1)
                    .addComponent(t1)
                    .addComponent(x0)
                    .addComponent(t6))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d1_x3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d1_x2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d1_x1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d1_x0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(actualX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ds1_x2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ds1_x1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ds1_x0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d2_x3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d2_x2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d2_x1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d2_x0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ds2_x2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ds2_x1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raiz1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raiz2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raiz3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_x3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_x2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_x1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(tf_xActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(residuo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(residuo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(residuo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_PdeX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tf_xNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_PAdeX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fraccionRaiz1)
                        .addComponent(fraccionRaiz2)
                        .addComponent(fraccionRaiz3)))
                .addGap(38, 38, 38)
                .addComponent(instruccionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SigPaso)
                    .addComponent(OmiPaso)
                    .addComponent(regresarButton))
                .addGap(33, 33, 33))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(192, 192, 192)
                    .addComponent(jLabel13)
                    .addContainerGap(385, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void d1_x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d1_x3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d1_x3ActionPerformed

    private void d1_x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d1_x2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d1_x2ActionPerformed

    private void d1_x0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d1_x0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d1_x0ActionPerformed

    private void d1_x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d1_x1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d1_x1ActionPerformed

    private void ds1_x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ds1_x2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ds1_x2ActionPerformed

    private void ds1_x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ds1_x1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ds1_x1ActionPerformed

    private void ds1_x0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ds1_x0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ds1_x0ActionPerformed

    private void d2_x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d2_x3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d2_x3ActionPerformed

    private void ds2_x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ds2_x2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ds2_x2ActionPerformed

    private void d2_x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d2_x2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d2_x2ActionPerformed

    private void d2_x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d2_x1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d2_x1ActionPerformed

    private void ds2_x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ds2_x1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ds2_x1ActionPerformed

    private void d2_x0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d2_x0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d2_x0ActionPerformed

    private void r_x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_x3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_x3ActionPerformed

    private void r_x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_x2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_x2ActionPerformed

    private void r_x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_x1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_x1ActionPerformed

    private void SigPasoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SigPasoMouseClicked
        // TODO add your handling code here:
        setNewXBlank();
        procedimiento();
    }//GEN-LAST:event_SigPasoMouseClicked

    private void OmiPasoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OmiPasoMouseClicked
        // TODO add your handling code here:
        while(paso != 8) {
            procedimiento();
        }
    }//GEN-LAST:event_OmiPasoMouseClicked

    private void regresarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarButtonMouseClicked
        Datosx3 b = new Datosx3();
        b.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_regresarButtonMouseClicked

    private void raiz2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raiz2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_raiz2ActionPerformed

    private void raiz3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raiz3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_raiz3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Resultadox3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultadox3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultadox3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultadox3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resultadox3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OmiPaso;
    private javax.swing.JButton SigPaso;
    private javax.swing.JTextField actualX;
    private javax.swing.JTextField d1_x0;
    private javax.swing.JTextField d1_x1;
    private javax.swing.JTextField d1_x2;
    private javax.swing.JTextField d1_x3;
    private javax.swing.JTextField d2_x0;
    private javax.swing.JTextField d2_x1;
    private javax.swing.JTextField d2_x2;
    private javax.swing.JTextField d2_x3;
    private javax.swing.JTextField ds1_x0;
    private javax.swing.JTextField ds1_x1;
    private javax.swing.JTextField ds1_x2;
    private javax.swing.JTextField ds2_x1;
    private javax.swing.JTextField ds2_x2;
    private javax.swing.JLabel fraccionRaiz1;
    private javax.swing.JLabel fraccionRaiz2;
    private javax.swing.JLabel fraccionRaiz3;
    private javax.swing.JTextField instruccionText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField r_x1;
    private javax.swing.JTextField r_x2;
    private javax.swing.JTextField r_x3;
    private javax.swing.JTextField raiz1;
    private javax.swing.JTextField raiz2;
    private javax.swing.JTextField raiz3;
    private javax.swing.JButton regresarButton;
    private javax.swing.JTextField residuo1;
    private javax.swing.JTextField residuo2;
    private javax.swing.JTextField residuo3;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t2;
    private javax.swing.JLabel t3;
    private javax.swing.JLabel t6;
    private javax.swing.JTextField tf_PAdeX;
    private javax.swing.JTextField tf_PdeX;
    private javax.swing.JTextField tf_xActual;
    private javax.swing.JTextField tf_xNueva;
    private javax.swing.JLabel x0;
    private javax.swing.JLabel x1;
    private javax.swing.JLabel x2;
    private javax.swing.JLabel x3;
    // End of variables declaration//GEN-END:variables
}
