package com.atlauncher.gui.panel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.atlauncher.gui.comp.SocialButton;

public final class SocialButtonsPanel extends JPanel{
	private static final long serialVersionUID = -5367215674165844919L;
	
	private final String[] BUTTONS = new String[]{
		"facebook", "github", "twitter",
		"reddit"
	};
	
	public SocialButtonsPanel(){
		super(new GridBagLayout());
		this.setMinimumSize(new Dimension(0, 50));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.insets.set(0, 5, 0, 0);
		for(int i = 0; i < this.BUTTONS.length; i++){
			this.add(new SocialButton(this.BUTTONS[i]), gbc);
			gbc.gridx++;
		}
	}
}