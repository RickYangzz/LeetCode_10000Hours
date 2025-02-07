import os

# 创建一个算法题的基本结构 (java|javascript|python)
def create_structure(problem_name):
    # Step 1: 创建目录结构
    os.makedirs(f"{problem_name}/java_solutions", exist_ok=True)
    os.makedirs(f"{problem_name}/javascript_solutions", exist_ok=True)
    os.makedirs(f"{problem_name}/python_solutions", exist_ok=True)
    
    # Step 2: 创建文件
    with open(f"{problem_name}/java_solutions/Solution.java", 'w') as f:
        f.write("// Java solution code here\n")
    
    with open(f"{problem_name}/javascript_solutions/Solution.ts", 'w') as f:
        f.write("// JavaScript solution code here\n")
    
    with open(f"{problem_name}/python_solutions/solution.py", 'w') as f:
        f.write("# Python solution code here\n")

    print(f"Structure for {problem_name} has been created.")

# Example usage
problem_name = "BM35_判断是不是完全二叉树"
create_structure(problem_name)
