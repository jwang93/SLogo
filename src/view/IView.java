package view;

import util.Location;
import model.IModel;

public interface IView {
	public void returnMessage(String message);

	public void clearCommandWindow();

	public void updatePositionLabel(Location location);

	public void updateHeadingLabel(int heading);

	public void setModel(IModel model);
}
