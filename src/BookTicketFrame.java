import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.*;

public class BookTicketFrame extends JFrame {

	//private ArrayLit<Movie> filmList = new ArrayList<Movie>();
	private String name;


	private JLabel movieL;
	private JLabel Screenings;
	private JLabel seatL;
	private JLabel nameL;
	private JLabel roomL;
	private JTextField Room1;
	private JComboBox<String> Movies;
	private JComboBox<String> seats;
	private JButton backButton;
	private JButton bookButton;
	private JComboBox<String> ScreeningsCombo;
	private JTextField nameField;
	private JRadioButton normalT;
	private JRadioButton childT;
	private JRadioButton studentT;
	private JRadioButton multiT;
	private JPanel panel;
	JFrame JFrame = this;
    private ArrayList<String> roomIDs = new ArrayList<>();

	private ImageIcon img= new ImageIcon("ticket icon.png");

    private ArrayList<String> moviesTitle = new ArrayList<>();


	public BookTicketFrame() {

        for (Movie m : Database.allMovies){
            moviesTitle.add(m.getTitle());
        }

        for(Room r : Database.allRooms){
            roomIDs.add(r.getRoomID());
        }
        Room1 = new JTextField();
        roomL= new JLabel("�������:");
        movieL = new JLabel("������: ");
        Screenings = new JLabel("�������: ");
        seatL = new JLabel("����: ");
        nameL = new JLabel("��o�/��: ");
        Movies = new JComboBox<String>();
		for(Movie movie:Database.allMovies) {
			String title = movie.getTitle();
			Movies.addItem(title);
		}
        backButton = new JButton("����");
        bookButton = new JButton("�������");

        ScreeningsCombo = new JComboBox<String>();



        nameField= new JTextField("");
        normalT = new JRadioButton("��������");
        childT = new JRadioButton("�������");
        studentT = new JRadioButton("���������");
        multiT = new JRadioButton("�����������");

        seats = new JComboBox<String>();

		ButtonListener listener = new ButtonListener();
		bookButton.addActionListener(listener);
		backButton.addActionListener(listener);
		Movies.addActionListener(listener);
        ScreeningsCombo.addActionListener(listener);

		this.setIconImage(img.getImage());
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(450,450);
		this.setTitle("������� ����������");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(null);

        panel.add(movieL);
        Dimension size1 = movieL.getPreferredSize();
        movieL.setBounds(100, 10, size1.width, size1.height);

        panel.add(Screenings);
        Dimension size2 = Screenings.getPreferredSize();
        Screenings.setBounds(100, 40, size2.width, size2.height);

        panel.add(roomL);
        Dimension size5 = roomL.getPreferredSize();
        roomL.setBounds(100, 70, size5.width, size5.height);

        panel.add(seatL);
        Dimension size3 = seatL.getPreferredSize();
        seatL.setBounds(100, 100, size3.width, size3.height);

        panel.add(nameL);
        Dimension size4 = nameL.getPreferredSize();
        nameL.setBounds(100, 130, size4.width, size4.height);

        Movies.setLocation(200, 10);
        Movies.setSize(200, 20);
        panel.add(Movies);

        ScreeningsCombo.setLocation(200, 40);
        ScreeningsCombo.setSize(200, 20);
        panel.add(ScreeningsCombo);

        Dimension size6 = Room1.getPreferredSize();
        Room1.setBounds(200, 70,size6.width,size6.height);
        panel.add(Room1);

        seats.setLocation(200, 100);
        seats.setSize(200, 20);
        panel.add(seats);

        nameField.setLocation(200, 130);
        nameField.setSize(200, 20);
        panel.add(nameField);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(normalT);
        buttonGroup.add(childT);
        buttonGroup.add(studentT);
        buttonGroup.add(multiT);

        normalT.setLocation(10, 200);
        normalT.setSize(100, 20);
        panel.add(normalT);
        childT.setLocation(120, 200);
        childT.setSize(100, 20);
        panel.add(childT);
        studentT.setLocation(230, 200);
        studentT.setSize(100, 20);
        panel.add(studentT);
        multiT.setLocation(340, 200);
        multiT.setSize(100, 20);
        panel.add(multiT);

        backButton.setLocation(80, 320);
        backButton.setSize(100, 25);
        panel.add(backButton);

        bookButton.setLocation(250, 320);
        bookButton.setSize(100, 25);
        panel.add(bookButton);
	}

	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if ( e.getSource().equals(bookButton)) {
			    // Get movie from JComboBox
                //String movie = String.valueOf(movies.getSelectedItem());
			    Movie selectedMovie = Database.getMovieFromTitle((String)Movies.getSelectedItem());
			    int selectedSeat = Integer.parseInt((String) seats.getSelectedItem());
			    String Screening = (String)ScreeningsCombo.getSelectedItem();
			    Room roomSelected = selectedMovie.getScreenings().get(Screening);

                String ticketType;
                if(normalT.isSelected()){
                    ticketType = "normal";
                }
                else if (childT.isSelected()){
                    ticketType = "child";
                }
                else if (studentT.isSelected()){
                    ticketType = "student";
                }
                else{
                    ticketType = "multi";
                }

                Database.allReservations.add(new Reservation(selectedMovie,selectedSeat, ticketType, roomSelected));
                Database.storeData();
                roomSelected.reserveSeat(selectedSeat-1);
                JOptionPane.showMessageDialog(null, "� ������� ����������������!");
				JFrame.dispose();
			}
			else if ( e.getSource().equals(backButton) ){
				JFrame.dispose();
			}
			else if(e.getSource().equals(Movies)){
                ScreeningsCombo.removeAllItems();
                Movie selectedMovie = Database.getMovieFromTitle((String)Movies.getSelectedItem());
                System.out.println(selectedMovie.getTitle());
                Set<String> keys = selectedMovie.getScreenings().keySet();
                for(String key:keys) {
                    ScreeningsCombo.addItem(key);
                }
                Room1.setText("");
                seats.removeAllItems();

            }
			else if(e.getSource().equals(ScreeningsCombo)) {
                Movie selectedMovie = Database.getMovieFromTitle((String)Movies.getSelectedItem());
                String SelectedScreening = (String)ScreeningsCombo.getSelectedItem();
                //seats.removeAllItems();
                Room roomSelected = selectedMovie.getScreenings().get(SelectedScreening);
                Room1.setText(roomSelected.getRoomID());

                ArrayList<Integer> empty = roomSelected.getEmptySeats();
                for(int i=0;i<empty.size();i++) {
                    String seat = Integer.toString(empty.get(i));
                    seats.addItem(seat);
                }
			}

            }
		}

	}

