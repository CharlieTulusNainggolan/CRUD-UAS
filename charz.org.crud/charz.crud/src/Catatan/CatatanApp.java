package Catatan;

import java.util.ArrayList;
import java.util.List;

public class CatatanApp
{
    private List<Catatan> catatanList = new ArrayList<>();

    public void tambahCatatan(Catatan catatan)
    {
        catatanList.add(catatan);
    }

    public List<Catatan> getCatatanList()
    {
        return catatanList;
    }

    public void hapusCatatan(int index)
    {
        catatanList.remove(index);
    }
}
