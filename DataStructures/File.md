      ArrayList<Integer> list = new ArrayList<>();
      
      Queue<Node> q = new LinkedList<>();
      
      if(root == null) return list;
      
      
      q.add(root);
      q.add(null);
      
      
      
      if(root != null)
      list.add(root.data);
      
      int count = 0;
      
      while(!q.isEmpty())
      {
        Node curr = q.remove();
        if(curr == null) 
        {
            count = 0;
            if(q.isEmpty()) break;
            else q.add(null);
        }
        else
        {
            if(count == 0)
            {
                if(curr.left != null) 
                {
                    q.add(curr.left);
                    list.add(curr.left.data);
                    count = 1;
                } 
                else if(curr.right != null)
                {
                    q.add(curr.right);
                    list.add(curr.right.data);
                    count = 1;
                }
            }
        }
      }
      q.clear();
      return list;
      