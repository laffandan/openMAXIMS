//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.assessment.forms.assessmentfavourites;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveFavouriteClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSelectClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyr1TabChanged(ims.framework.LayerBridge tab);
	abstract protected void onGrdAssessmentSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdAssessmentGridCheckBoxClicked(int column, GenForm.lyr1Layer.tabSearchContainer.grdAssessmentRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroup1ValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreFavouritesTreeViewNodeDropped(ims.framework.controls.TreeNode node, ims.framework.controls.TreeNode previousParentNode) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreFavouritesTreeViewCheck(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreFavouritesTreeViewSelectionChanged(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormOpen(args);
			}
		});
		this.form.btnSaveFavourite().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveFavouriteClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
		this.form.btnSelect().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSelectClick();
			}
		});
		this.form.lyr1().tabSearch().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabSearchActivated();
			}
		});
		this.form.lyr1().tabFavourites().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabFavouritesActivated();
			}
		});
		this.form.lyr1().tabSearch().grdAssessment().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAssessmentSelectionChanged();
			}
		});
		this.form.lyr1().tabSearch().grdAssessment().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAssessmentGridCheckBoxClicked(column, new GenForm.lyr1Layer.tabSearchContainer.grdAssessmentRow(row), isChecked);
			}
		});
		this.form.lyr1().tabSearch().Group1().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroup1ValueChanged();
			}
		});
		this.form.lyr1().tabSearch().imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.lyr1().tabSearch().imbSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchClick();
			}
		});
		this.form.lyr1().tabFavourites().treFavourites().setTreeViewNodeDroppedEvent(new TreeViewNodeDropped()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.TreeNode node, ims.framework.controls.TreeNode previousParentNode) throws ims.framework.exceptions.PresentationLogicException
			{
				onTreFavouritesTreeViewNodeDropped(node, previousParentNode);
			}
		});
		this.form.lyr1().tabFavourites().treFavourites().setTreeViewCheckEvent(new TreeViewCheck()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException
			{
				onTreFavouritesTreeViewCheck(node);
			}
		});
		this.form.lyr1().tabFavourites().treFavourites().setTreeViewSelectionChangedEvent(new TreeViewSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException
			{
				onTreFavouritesTreeViewSelectionChanged(node);
			}
		});
		this.form.getContextMenus().getFavouritesAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.Favourites.Add, sender);
			}
		});
		this.form.getContextMenus().getFavouritesAddNewFolderItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.Favourites.AddNewFolder, sender);
			}
		});
		this.form.getContextMenus().getFavouritesEditFolderItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.Favourites.EditFolder, sender);
			}
		});
		this.form.getContextMenus().getFavouritesRemoveFolderItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.Favourites.RemoveFolder, sender);
			}
		});
	}
	private void onlyr1tabSearchActivated()
	{
		this.form.lyr1().showtabSearch();
		onlyr1TabChanged(this.form.lyr1().tabSearch());
	}
	private void onlyr1tabFavouritesActivated()
	{
		this.form.lyr1().showtabFavourites();
		onlyr1TabChanged(this.form.lyr1().tabFavourites());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}