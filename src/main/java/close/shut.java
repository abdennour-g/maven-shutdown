package close;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class shut {
    private JFrame           fr      = new JFrame();
    private JPanel           panel   = new JPanel();
    private Rectangle        r       = new Rectangle( 200, 140, 246, 483 );
    private Color            c       = Color.white;
    private JLabel           sinc;
    private static final int sec     = 1000, min = 60, heur = 24;
    private Calendar         cal     = Calendar.getInstance();
    private LocalDateTime    parsed1 = LocalDateTime.now();
    private temp             ok      = new temp( 0, 10, 0 );
    private temp             wit     = new temp( ( parsed1.getHour() + ok.h ), ( parsed1.getMinute() + ok.m ),
            ( parsed1.getSecond() + ok.s ) );
    private JPanel           panel_1;
    private JButton          now_;
    private JButton          min_;
    private JButton          ten;
    private JButton          therti;
    private JButton          two_h;
    private JButton          ferm;
    private final String     act    = "notepad";
    private final String     act1     = "shutdown /h";
    private final String     msg_    = "fermeture après:";
    private int              i       = 0, j = 0;
    private JLabel           msg;

    public shut() {
        fr.setUndecorated( true );
        //  fr.setType( Type.UTILITY );
        fr.getContentPane().setBackground( c );
        fr.setDefaultCloseOperation( fr.EXIT_ON_CLOSE );
        fr.setSize( (int) r.getWidth(), (int) r.getHeight() );
        fr.setVisible( true );
        fr.getContentPane().setLayout( null );
        fr.setLocationRelativeTo( null );
        Image img = Toolkit.getDefaultToolkit().getImage( "c:/close.png" );
        fr.setIconImage( img );

        fr.getContentPane().add( panel );
        panel.setBounds( 0, 0, (int) r.getWidth(), (int) r.getHeight() );
        panel.setBackground( c );
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 246, 0 };
        gbl_panel.rowHeights = new int[] { 111, 261, 111, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout( gbl_panel );

        sinc = new JLabel( "" );
        sinc.setHorizontalTextPosition( SwingConstants.CENTER );
        sinc.setHorizontalAlignment( SwingConstants.CENTER );
        sinc.setForeground( Color.blue );
        sinc.setFont( new Font( "Trebuchet MS", Font.PLAIN, 15 ) );
        sinc.setBackground( Color.blue );
        sinc.setOpaque( true );
        GridBagConstraints gbc_sinc = new GridBagConstraints();
        gbc_sinc.fill = GridBagConstraints.BOTH;
        gbc_sinc.insets = new Insets( 0, 0, 5, 0 );
        gbc_sinc.gridx = 0;
        gbc_sinc.gridy = 0;
        panel.add( sinc, gbc_sinc );

        panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.insets = new Insets( 0, 0, 5, 0 );
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 1;
        panel.add( panel_1, gbc_panel_1 );
        panel_1.setLayout( new GridLayout( 6, 1, 0, 0 ) );

        now_ = new JButton( "now" );
        now_.setForeground(new Color(25, 25, 112));
        now_.setBackground(Color.ORANGE);
        panel_1.add( now_ );
        now_.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                closed( 0 );
            }

        } );
        min_ = new JButton( "min" );
        min_.setForeground(new Color(25, 25, 112));
        min_.setBackground(Color.ORANGE);
        panel_1.add( min_ );
        min_.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                closed( 1 );
            }

        } );

        ten = new JButton( "10 min" );
        ten.setForeground(new Color(25, 25, 112));
        ten.setBackground(Color.ORANGE);
        panel_1.add( ten );
        ten.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                closed( 10 );
            }

        } );
        therti = new JButton( "30 min" );
        therti.setForeground(new Color(25, 25, 112));
        therti.setBackground(Color.ORANGE);
        panel_1.add( therti );
        therti.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                closed( 30 );
            }

        } );
        two_h = new JButton( "2 h" );
        two_h.setForeground(new Color(25, 25, 112));
        two_h.setBackground(Color.ORANGE);
        panel_1.add( two_h );

        two_h.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                closed( 120 );
            }

        } );

        ferm = new JButton( "close" );
        ferm.setForeground( Color.WHITE );
        ferm.setBackground( new Color( 255, 0, 0 ) );
        panel_1.add( ferm );

        ferm.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.exit( 0 );
                fr.dispose();
            }

        } );

        msg = new JLabel( "" );
        msg.setOpaque( true );
        msg.setHorizontalTextPosition( SwingConstants.CENTER );
        msg.setHorizontalAlignment( SwingConstants.CENTER );
        msg.setForeground( Color.WHITE );
        msg.setFont( new Font( "Trebuchet MS", Font.PLAIN, 15 ) );
        msg.setBackground( new Color( 25, 25, 112 ) );
        GridBagConstraints gbc_msg = new GridBagConstraints();
        gbc_msg.fill = GridBagConstraints.BOTH;
        gbc_msg.gridx = 0;
        gbc_msg.gridy = 2;
        panel.add( msg, gbc_msg );

        panel.repaint();
        panel.revalidate();
        getSinc();
    }

    public void getSinc() {
        temp rev = new temp( 2, 0, 0 );
        while ( i > -1 ) {
            try {
    
                Thread.sleep( sec );

                sinc.setText( frm( j ) + ":" + frm( i ) );
                i++;
                if ( i == 60 ) {
                    i = 0;
                    j++;
                }
                sinc.repaint();
                sinc.revalidate();
            } catch ( InterruptedException e1 ) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
    
        }
    }

    public String frm( int t ) {
        return t < 10 ? "0" + t : "" + t;
    }

    public void closed( int n ) {
        int sec = 1000, min = 60;
        int tm = n * min;
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        try {
                            Runtime.getRuntime().exec( act );
                        } catch ( IOException e ) {
                            e.printStackTrace();
                        }
                      }
                },
                n * sec * min );
        msg.setText( msg_ + " " + n + " min" );
        i = 1;
        j = 0;
        sinc.setForeground( Color.WHITE );
    }

    class temp {
        public int h, m, s;

        public temp( int h, int m, int s ) {
            this.h = h;
            this.m = m;
            this.s = s;
        }
    }

    public static void main( String[] args ) {
        new shut();
    }
    }
