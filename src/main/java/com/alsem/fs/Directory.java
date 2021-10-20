package com.alsem.fs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory extends FsEntity
{
    protected String name;
    protected Directory parent;
    
    private List<FsEntity> entries;
    public Directory(String name, Directory parent)
    {
        super(name, parent);
        entries = new ArrayList<>();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Directory directory = (Directory) o;
        return Objects.equals(parent, directory.parent) && name.equals(directory.name);
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(name,parent);
    }
    
    public boolean removeChild(FsEntity fsEntity)
    {
        return entries.remove(fsEntity);
    }
    
    public boolean addChild(FsEntity fsEntity)
    {
        return entries.add(fsEntity);
    }
    
    public List<FsEntity> getEntries()
    {
        return entries;
    }
    
    public boolean searchEntry(String name)
    {
        return entries.stream().anyMatch(fsEntity -> fsEntity.getName().equals(name));
    }
}
