import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

public class DetailedRoutineUI extends JFrame {
	public DetailedRoutineUI() {
		setTitle("GOODBYE-OFFICE");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// ���� �г� ����
		JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBackground(new Color(250, 240, 230));
		mainPanel.setBorder(new EmptyBorder(20, 40, 20, 40));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 0);
		
		// ��Ʈ ����
		Font buttonFont = new Font("Malgun Gothic", Font.PLAIN, 13);
		Font labelFont = new Font("Malgun Gothic", Font.PLAIN, 16);
		Font titleFont = new Font("Malgun Gothic", Font.BOLD, 22);
		
		// ��� ������ ��ư �г� (����/Ȩ)
		JPanel topButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		topButtonPanel.setBackground(mainPanel.getBackground());
		JButton settingButton = new JButton("����");
		JButton homeButton = new JButton("Ȩ");
		settingButton.setFont(buttonFont);
		homeButton.setFont(buttonFont);
		topButtonPanel.add(settingButton);
		topButtonPanel.add(homeButton);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		mainPanel.add(topButtonPanel, gbc);
		
		// ��� ����
        gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel titleLabel = new JLabel("������ ��ƾ�� ��õ�� �帱�Կ�! ���� �׸��� ������ �ּ���.");
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(new Color(0x4E4E4E));
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		mainPanel.add(titleLabel, gbc);
		
		// ���μ�
		gbc.gridy++;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.weighty = 0;
		
		JPanel linePanel = new JPanel();
		linePanel.setBackground(new Color(0x4E4E4E));
		linePanel.setPreferredSize(new Dimension(600, 2));
		linePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
		linePanel.setMinimumSize(new Dimension(10, 2));
		mainPanel.add(linePanel, gbc);
		gbc.gridwidth = 1;
		
		// ī�װ��� �׸� �г�
		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
		categoryPanel.setOpaque(false);
		
		addCategory(categoryPanel, "�Ļ�",
			new String[]{"���ο쵿", "��������", "�������", "�����", "�������"},
			new String[]{
				"C:/Users/jjoo4/OneDrive/���� ȭ��/food/���ο쵿.png",
				"C:/Users/jjoo4/OneDrive/���� ȭ��/food/��������.png",
				"C:/Users/jjoo4/OneDrive/���� ȭ��/food/�������.png",
				"C:/Users/jjoo4/OneDrive/���� ȭ��/food/�����.png",
				"C:/Users/jjoo4/OneDrive/���� ȭ��/food/�������.png"
			});
		
		addCategory(categoryPanel, "OTT",
			new String[]{"���ø��� \n <���õ� ������>", "��í <�ް��� �� ����?>"},
			new String[]{
				"C:/Users/jjoo4/OneDrive/���� ȭ��/food/���ο쵿.png",
				"C:/Users/jjoo4/OneDrive/���� ȭ��/food/��������.png"
			});
		
		addCategory(categoryPanel, "��Ʈ��Ī",
			new String[]{"��Ʃ�� <10�� ���� Ǯ�� ��ƾ - ������ �ؼ�>"},
			new String[]{
				"C:/Users/jjoo4/OneDrive/���� ȭ��/food/���ο쵿.png"
			});
		
		addCategory(categoryPanel, "�ڱ���",
			new String[]{"�Ϸ� 1�ܾ� ���� �ϱ� �� ���", "å <���� ���� ������ ��> 10�� �б�"},
			new String[]{
				"C:/Users/jjoo4/OneDrive/���� ȭ��/food/���ο쵿.png",
				"C:/Users/jjoo4/OneDrive/���� ȭ��/food/��������.png"
			});
		addCategory(categoryPanel, "������",
			new String[]{"��ī���� �� ����", "�Ϸ� ���� �ϱ� ���� ��(Mooda, DailyBean) ���"},
			new String[]{
				"C:/Users/jjoo4/OneDrive/���� ȭ��/food/���ο쵿.png",
				"C:/Users/jjoo4/OneDrive/���� ȭ��/food/��������.png"
			});
		
		JScrollPane scrollPane = new JScrollPane(categoryPanel);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		mainPanel.add(scrollPane, gbc);
		
		// ���� �Ϸ� ��ư (�ϴ� ������)
		gbc.gridy++;
		gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.setBackground(mainPanel.getBackground());
		JButton submitButton = new JButton("���� �Ϸ�");
		submitButton.setFont(buttonFont);
		submitButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "�Է��� �Ϸ�Ǿ����ϴ�."));
		buttonPanel.add(submitButton);
		gbc.gridx = 1;
		mainPanel.add(buttonPanel, gbc);
		
		add(mainPanel);
		setVisible(true);
	}
	
	private void addCategory(JPanel parent, String title, String[] options, String[] imagePaths) {
		JPanel categoryBox = new JPanel();
		categoryBox.setLayout(new BorderLayout());
		categoryBox.setOpaque(false);
		categoryBox.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
		
		JLabel categoryTitle = new JLabel(title);
		categoryTitle.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		categoryBox.add(categoryTitle, BorderLayout.NORTH);
		
		JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		optionPanel.setOpaque(false);
		ButtonGroup group = new ButtonGroup();
		
		for (int i = 0; i < options.length; i++) {
			final int index = i;
			
			JToggleButton button = new JToggleButton(){
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					
					if (isSelected()) {	// ��ο� ��������
						g.setColor(new Color(0, 0, 0, 100)); // ������ ����
						g.fillRect(0, 0, getWidth(), getHeight());

						// ��� üũ ������
						g.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
						g.setColor(Color.WHITE);
						FontMetrics fm = g.getFontMetrics();
						String check = "V";
						int x = (getWidth() - fm.stringWidth(check)) / 2;
						int y = (getHeight() + fm.getAscent()) / 2 - 8;
						g.drawString(check, x, y);
					}
				}
			};
			
			button.setLayout(new BorderLayout());
			button.setPreferredSize(new Dimension(150, 180));
			button.setText("<html><center>" + options[i] + "</center></html>");
			button.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
			button.setVerticalTextPosition(SwingConstants.BOTTOM);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			button.setIcon(new ImageIcon(imagePaths[i]));
			
			button.setContentAreaFilled(false);
			button.setOpaque(false);
			button.setFocusPainted(false);
			button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
			
			button.setVerticalAlignment(SwingConstants.TOP);
			button.setVerticalTextPosition(SwingConstants.BOTTOM);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			
			group.add(button);
			optionPanel.add(button);
		}
		
		categoryBox.add(optionPanel, BorderLayout.CENTER);
		parent.add(categoryBox);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new DetailedRoutineUI());
	}
}
