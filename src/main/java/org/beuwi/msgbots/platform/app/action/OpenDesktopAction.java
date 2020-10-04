package org.beuwi.msgbots.platform.app.action;

import org.beuwi.msgbots.platform.app.impl.Action;

import java.awt.Desktop;
import java.io.File;

public class OpenDesktopAction implements Action
{
	@Override
	public void init()
	{

	}

	public static void execute()
	{
		// execute(FileManager.BOTS_FOLDER);
	}

	public static void execute(String path)
	{
		execute(new File(path));
	}

	public static void execute(File file)
	{
		try
		{
			Desktop.getDesktop().open(file);
		}
		catch (Exception e)
		{
		   //  new ShowErrorDialog(e).display();
		}
	}

	@Override
	public String getName()
	{
		return "open.desktop.action";
	}
}