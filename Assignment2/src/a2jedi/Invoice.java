package a2jedi;

import java.util.ArrayList;

public class Invoice {
	private String customer;
	private double total_cost;
	private ArrayList<InvoiceItem> items;
	private int invoice_number;
	private static int invoice_number_tracker = 1;

	public Invoice(String customer) {
		this.customer = customer;
		this.total_cost = 0;
		this.items = new ArrayList<InvoiceItem>();
		this.invoice_number = invoice_number_tracker;
		invoice_number_tracker++;
	}

	public InvoiceItem findItemByName(String name) {
		for (InvoiceItem item : items) {
			if (item.getName().equals(name)) {
				return item;
			}
		}

		return null;
	}

	public InvoiceItem removeFromInvoice(String name) {
		for (InvoiceItem item : items) {
			if (item.getName().equals(name)) {
				total_cost = total_cost - item.getCost();
				items.remove(item);
				return item;
			}
		}

		return null;
	}

	public void addToInvoice(InvoiceItem new_item) {
		int new_unit_count = 0;
		double new_total_cost = 0;
		double new_price_per_unit = 0;

		// This if statement calls the findItemByName() method. If that method does
		// not find an item that matches the name of the item we input and returns
		// null, then the new item is added to our invoice.
		if (this.findItemByName(new_item.getName()) == null) {
			items.add(new_item);
			total_cost = total_cost + new_item.getCost();
		}

		// If findItemByName() does find an item that matches the name of the item we
		// input, we add the values of the instance variables of the InvoiceItem already
		// in our invoice to the values of the instance variables of the InvoiceItem we
		// just input and store those new values in new variables. Then we remove the old
		// InvoiceItem, create a new InvoiceItem using the variables we just created as
		// parameters, and add this to our invoice.
		else {
			new_unit_count = new_item.getUnitCount()
					+ this.findItemByName(new_item.getName()).getUnitCount();

			new_total_cost = new_item.getCost()
					+ this.findItemByName(new_item.getName()).getCost();

			new_price_per_unit = new_total_cost / new_unit_count;

			total_cost = total_cost - findItemByName(new_item.getName()).getCost();
			
			items.remove(findItemByName(new_item.getName()));

			InvoiceItem newItem = new InvoiceItem(new_item.getName(),
					new_price_per_unit, new_unit_count);

			items.add(newItem);
			
			total_cost = total_cost + newItem.getCost();
		}
	}

	public InvoiceItem[] findItemsByNameFilter(String filter,
			boolean strict_prefix) {

		ArrayList<InvoiceItem> temp_matches = new ArrayList<InvoiceItem>();

		// Depending on whether strict_prefix is true or false, we use either
		// the startsWith() or contains() method to add matches to our arraylist.
		// Later we transform our arraylist of matches into an array of
		// InvoiceItem.
		if (strict_prefix == true) {
			for (InvoiceItem item : items) {
				if (item.getName().startsWith(filter)) {
					temp_matches.add(item);
				}
			}
			
			if (temp_matches.size() == 0) {
				return null;
			}
			else {
				InvoiceItem[] matches = new InvoiceItem[temp_matches.size()];
				matches = temp_matches.toArray(matches);
				return matches;
			}
		}
		else {
			for (InvoiceItem item : items) {
				if (item.getName().contains(filter)) {
					temp_matches.add(item);
				}
			}
			
			if (temp_matches.size() == 0) {
				return null;
			}
			else {
				InvoiceItem[] matches = new InvoiceItem[temp_matches.size()];
				matches = temp_matches.toArray(matches);
				return matches;
			}
		}
	}

	public Invoice separateByNameFilter(String filter, boolean strict_prefix) {
		InvoiceItem[] matches = this.findItemsByNameFilter(filter,
				strict_prefix);

		if (matches.length == 0) {
			return null;
		}

		Invoice newInvoice = new Invoice(this.customer);

		for (int i = 0; i < matches.length; i++) {
			this.removeFromInvoice(matches[i].getName());
			newInvoice.addToInvoice(matches[i]);
		}

		return newInvoice;
	}

	public String getCustomer() {
		return customer;
	}

	public double getTotalCost() {
		return total_cost;
	}

	public int getInvoiceNumber() {
		return invoice_number;
	}
}