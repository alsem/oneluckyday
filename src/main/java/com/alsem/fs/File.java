package com.alsem.fs;

public class File extends FsEntity
{
    private String fileContents;
    
    public File(String name, Directory parent)
    {
        super(name, parent);
    }

    
    public String getFileContents()
    {
        return fileContents;
    }
    
    public void setFileContents(String fileContents)
    {
        this.fileContents = fileContents;
    }
    
}
