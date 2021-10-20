package com.alsem.fs;

import java.util.Objects;

public abstract class FsEntity
{
    protected String name;
    protected Directory parent;
    
    public String getName()
    {
        return name;
    }
    
    public Directory getParent()
    {
        return parent;
    }
    
    public FsEntity(String name, Directory parent)
    {
        this.name = name;
        this.parent = parent;
    }
    
    public boolean delete()
    {
        if (parent == null)
            return false;
        return parent.removeChild(this);
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
}
