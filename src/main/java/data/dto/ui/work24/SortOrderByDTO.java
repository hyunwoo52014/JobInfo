package data.dto.ui.work24;

import lombok.Data;

@Data
public class SortOrderByDTO {
	String label_abbreviation;
	String label;

	@Override
	public String toString() {
		return label;
	}
}
