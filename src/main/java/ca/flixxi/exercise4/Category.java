package ca.flixxi.exercise4;

/**
 * Created by Flyne on 14/06/2015.
 */
public enum Category {
    THRILLER("thriller"), COMEDY("comedy"), SERIE("serie"), DRAMA("drama"), NONFICTION("non-fiction"), SCIFI("sci-fi");

    private String label;

    Category(String label) {
        this.label = label;
    }

    Category() {
    }

    public String getLabel() {
        return label;
    }



    public static Category findCategorybyLabel(String label) throws NoCategoryFoundException  {
        Category rightCategory=null;
        for (Category category : values()) {
            if(category.label.equals(label))    {
                rightCategory = category;
                return rightCategory;
            }
        }
        if (rightCategory == null)   {
            throw new NoCategoryFoundException();
        } else  {
            return rightCategory;
        }

    }
}
