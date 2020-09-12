import os
import pprint

# Executing a shell command.
print(os.system('date'))

# Get the users environment 
env_var=os.environ
# Print the list of user's environment variables 
print("User's Environment variable:") 
pp=pprint.PrettyPrinter(indent=41, width=1)
pp.pprint(dict(env_var))

#Returns the current working directory.
pwd=os.getcwd()
print(pwd)

# Return the real group id of the current process.
print("Group id:", os.getgid())       

# Return the current process’s user id.
print("User id:", os.getuid())

# Returns the real process ID of the current process.
print("Process ID:", os.getpid())     

# Set the current numeric umask and return the previous umask.
mask=18
p=os.umask(mask)
print("Previous mask: ",p)   
print("Keeping the mask same: ",os.umask(p))   

# Return information identifying the current operating system.
print("Current operating system: ", os.uname())     

# TO BE CAREFUL WITH THIS COMMAND.
# Change the root directory of the current process to path.
# Will change the root (current: /home/crossbow/ {Mine}) to path.
# os.chroot(path)
# Hence, not made to run this function

# Return a list of the entries in the directory given by path.
print(os.listdir(pwd))

# Create a directory named path with numeric mode mode.
path='practice'
# os.mkdir(path[,mode]), mode default at 0o777.
os.mkdir(path)
print('Created new directory:')
print(os.listdir(pwd))    
path1=path

# Recursive directory creation function.
# A EXAMPLE:
directory = "samples"
parent_dir = "/home/User/practice/Python"
path = os.path.join(parent_dir, directory)
try:
	os.makedirs(path,exist_ok=true)
	# (exist_ok) Checks if dir is already there or not.
	print("Directory created or was already there.")
except:
	print("Not possible") 

# REMOVING GOES SAME.
# Remove (delete) the file path.
try:
	os.remove(path1)
	print('Removed the mentioned file:', path1)
	print(os.listdir(pwd))
except:
	print("Mentioned name of the content was not a file.")

# Remove directories recursively.
try:
	os.removedirs(path1)
	print('Removed the mentioned directories:', path1)
	print(os.listdir(pwd))
except:
	print("already REMOVED OR was not there never.")

# Rename the file or directory src to dst.
src='requirements.txt'
dst='reqFile.txt'
os.rename(src, dst)  
print('Renamed the mentioned file:', src)
print(os.listdir(pwd))

# Remove (delete) the directory path.
dirt='git'
parent_dir='/home/crossbow'
path=os.path.join(parent_dir,dirt)
print("Before removing the mentioned directory:", parent_dir)
print(os.listdir(parent_dir))
os.rmdir(path)
print('Removed the mentioned directory:', path)
print(os.listdir(parent_dir))