import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RoutineManagementPage extends JFrame {

    public RoutineManagementPage() {
        setTitle("루틴 관리");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(13, 39, 84)); // NAVY
        setLayout(null);

        // 화면 너비와 높이 가져오기
        int frameWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int frameHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        JLabel titleLabel = new JLabel("루틴 관리");
        titleLabel.setFont(new Font("dialog", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds((frameWidth - 200) / 2, 40, 200, 40);
        add(titleLabel);

        String[] columns = {"이름", "사번", "전화번호", "최근 접속일", "관리"};
        Object[][] data = {
                {"김아무개", "12345678", "010-0000-0000", "25/05/19", "삭제"},
                {"이아무개", "12345678", "010-9999-0000", "25/05/19", "삭제"},
                {"박아무개", "12345678", "010-0000-0000", "25/05/19", "삭제"},
                {"최아무개", "12345678", "010-0000-0000", "25/05/19", "삭제"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // "삭제" 버튼 열만 편집 가능
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.getColumn("관리").setCellRenderer(new ButtonRenderer());
        table.getColumn("관리").setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds((frameWidth - 800) / 2, 100, 800, 300); // 가운데 정렬 + 사이즈 지정
        add(scrollPane);

        setVisible(true);
    }

    // 버튼 렌더러
    class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
            setText("삭제");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // 버튼 에디터
    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private boolean clicked;
        private int selectedRow;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton("삭제");
            button.setOpaque(true);

            button.addActionListener((ActionEvent e) -> {
                clicked = true;
                fireEditingStopped();
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            selectedRow = row;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (clicked) {
                System.out.println("루틴 삭제 처리: " + selectedRow + "번째 사용자");
                ((DefaultTableModel) ((JTable) getComponent()).getModel()).removeRow(selectedRow);
            }
            clicked = false;
            return "삭제";
        }

        @Override
        public boolean stopCellEditing() {
            clicked = false;
            return super.stopCellEditing();
        }
    }

    public static void main(String[] args) {
        new RoutineManagementPage();
    }
}
