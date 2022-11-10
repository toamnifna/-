package menu.menu;

import utils.RegularUtils;

import java.io.IOException;

/**
 * @author 陶敏帆
 * @version 1.0
 */
public class BeginMenu extends Menu {

    private static final BeginMenu beginMenu = new BeginMenu();

    private BeginMenu() {
        setTitle("开始界面");
        setContext("定时关机", "取消定时关机", "刷新");
    }

    @Override
    public void show() throws IOException {
        Menu.title(getTitle());
        Menu.context(getContext());

        while (true) {

            switch (Integer.parseInt(RegularUtils.input())) {
                case 1:
                    TimeOutMenu.getInstance().setLastMenu(this);
                    TimeOutMenu.getInstance().show();
                    break;
                case 2:
                    QuitTimeOutMenu.getInstance().setLastMenu(this);
                    QuitTimeOutMenu.getInstance().show();
                    break;
                case 3:
                    show();
                    break;
            }
        }
    }

    public static BeginMenu getInstance() {
        return beginMenu;
    }
}