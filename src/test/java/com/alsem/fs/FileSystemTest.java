package com.alsem.fs;

public class FileSystemTest
{
    private FileSystem fileSystem = new FileSystem();
    
    public void shouldCreateRootDirectory(){
        Directory mockRoot = new Directory("root_dir", null);
        Directory rootDirectory = fileSystem.createDirectory("root_dir", null);
        //assertEquals(rootDirectory, mockRoot);
    }
}
