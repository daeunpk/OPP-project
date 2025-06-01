import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UserManagementPage extends JFrame {

    public UserManagementPage() {
        setTitle("유저 관리");
        UIStyle.applyFrameStyle(this);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(13, 39, 84)); // NAVY
        setLayout(null);

        String[] columns = {"이름", "사번", "전화번호", "최근 접속일", "관리"};
        Object[][] data = {
                {"김아무개", "12345678", "010-0000-0000", "25/05/19", "탈퇴"},
                {"박아무개", "12345678", "010-9999-0000", "25/05/19", "탈퇴"},
                {"이아무개", "12345678", "010-0000-0000", "25/05/19", "탈퇴"},
                {"최아무개", "12345678", "010-0000-0000", "25/05/19", "탈퇴"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            // 마지막 열의 버튼 생성을 위해 editable 설정
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // "탈퇴" 버튼 열만 편집 가능
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(30);

        // "탈퇴" 버튼 넣기
        table.getColumn("관리").setCellRenderer(new ButtonRenderer());
        table.getColumn("관리").setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setVisible(true);
    }

    // 셀 렌더러: 버튼처럼 보이게 하기
    class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
            setText("탈퇴");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // 셀 에디터: 버튼 누르면 동작하도록 처리
    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean clicked;
        private int selectedRow;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton("탈퇴");
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
                // 실제 탈퇴 로직은 여기서 구현
                System.out.println("탈퇴 처리: " + selectedRow + "번째 사용자");
                // 예: 테이블에서 행 삭제
                ((DefaultTableModel) ((JTable) getComponent()).getModel()).removeRow(selectedRow);
            }
            clicked = false;
            return "탈퇴";
        }

        @Override
        public boolean stopCellEditing() {
            clicked = false;
            return super.stopCellEditing();
        }
    }

    // 테스트용 main
    public static void main(String[] args) {
        new UserManagementPage();
    }
}
