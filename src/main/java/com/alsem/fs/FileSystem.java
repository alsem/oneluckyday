package com.alsem.fs;

public class FileSystem
{
    private final Directory rootDir;
    
    public FileSystem()
    {
        this.rootDir = createDirectory("root_dir", null);
    }
    
    public Directory createDirectory(String name, Directory parent)
    {
        return new Directory(name, parent);
    }
    
    public File createFile(String name, Directory parent)
    {
        return new File(name, parent);
    }
    
    public File createFileWithContents(String name, Directory parent, String contents)
    {
        File file = createFile(name, parent);
        file.setFileContents(contents);
        return file;
    }
    
    public boolean deleteDirectory(String name)
    {
        Directory currentEntry = rootDir;
        if (deleteRecursively(name, currentEntry))
        {
            return true;
        }
    
        return false;
    }
    
    private boolean deleteRecursively(String name, Directory currentEntry)
    {
        for (FsEntity entry : currentEntry.getEntries())
        {
            if (entry instanceof Directory)
            {
                if (name.equals(entry.getName()))
                {
                    entry.delete();
                    return true;
                } else
                {
                    return deleteRecursively(name, currentEntry);
                }
            }
        }
        return false;
    }
    
    public File search(String name)
    {
        File file = searchRecursively(name, rootDir);
        if (file != null)
        {
            return file;
        }
        return null;
    }
    
    private File searchRecursively(String name, Directory currentEntry)
    {
        for (FsEntity entry : currentEntry.getEntries())
        {
            if (entry instanceof File)
            {
                if (name.equals(entry.getName()))
                {
                    return (File) entry;
                } else
                {
                    return searchRecursively(name, currentEntry);
                }
            }
        }
        return null;
    }
}
